from LLMDecorator import LLMDecorator
from LLM import LLM
import requests

class TranslationDecorator(LLMDecorator):
    def __init__(self, llm: LLM, modelo_traduccion, api_token):
        
        super().__init__(llm)
        self.modelo_traduccion = modelo_traduccion
        self.api_token = api_token

    def generate_summary(self, text: str):
        # Llamamos al método generate_summary del objeto LLM original para obtener el resumen.
        summary = self.llm.generate_summary(text)
        url = f"https://router.huggingface.co/hf-inference/models/{self.modelo_traduccion}"        
        headers = {"Authorization": f"Bearer {self.api_token}"}
        payload = {"inputs": summary}
        response = requests.post(url, headers=headers, json=payload)
        result = response.json()
        print("Respuesta de la API:", result)
        if isinstance(result, list) and len(result) > 0:   # Verificamos que result sea una lista y no esté vacía. 
            if "translation_text" in result[0]: # Verificamos que el primer elemento de la lista tenga la clave "translation_text".
                return result[0]["translation_text"] # Devolvemos el texto traducido que se encuentra en la clave "translation_text" del primer elemento de la lista.

        return str(result) # Si no se cumple alguna de las condiciones anteriores, devolvemos el resultado completo como una cadena. Esto puede ser útil para depurar o entender qué salió mal en la respuesta de la API.