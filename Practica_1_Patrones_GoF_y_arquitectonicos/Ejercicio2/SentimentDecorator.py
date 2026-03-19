from LLMDecorator import LLMDecorator
from LLM import LLM
import requests 
# Decorador concreto (sentimientos) que extienda de LLMDecorator. 
# Este decorador se encargará de analizar el sentimiento del resumen generado por el modelo de lenguaje (LLM) y agregar esa información al resultado final mediante estrellas.

class SentimentDecorator(LLMDecorator):
    #Constructor que recibe el modelo de lenguaje, el modelo de sentimiento y el token de autenticación para la API de Hugging Face.
    def __init__(self, llm, modelo_sentimiento, api_token):
        super().__init__(llm)
        self.modelo_sentimiento = modelo_sentimiento
        self.api_token = api_token
    #Método 'generate_summary' que primero llama al método 'generate_summary' del modelo de lenguaje para obtener el resumen, luego realiza una solicitud a la API de Hugging Face para analizar el sentimiento del resumen 
    # y finalmente devuelve el resumen junto con la información del sentimiento.
    def generate_summary(self, text: str):
        summary = super().generate_summary(text)
        url = f"https://router.huggingface.co/hf-inference/models/{self.modelo_sentimiento}"        
        headers = {"Authorization": f"Bearer {self.api_token}"}
        payload = {"inputs": summary}
        response = requests.post(url, headers=headers, json=payload)
        result = response.json()
        print(result)
        # Verificamos que result sea una lista y no esté vacía. 
        if isinstance(result, list) and len(result) > 0:
            scores = result[0]  # Cogemos 1er resultado de la lista. 
            best = max(scores, key=lambda x: x["score"]) # Encontramos el diccionario con la puntuación más alta utilizando la función max y una función lambda que extrae la puntuación de cada diccionario.
            label = best["label"] #Nos quedamos con la etiqueta del diccionario que tiene la puntuación más alta.
            return summary + " | Sentiment: " + label # Devolvemos el resumen junto con la etiqueta del sentimiento (las estrellas, en este caso). 
        else:
            return f"Error en sentimiento: {result}" # Sino lanzamos error. 