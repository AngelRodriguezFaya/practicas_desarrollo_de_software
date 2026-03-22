
from unittest import result

import requests
from LLM import LLM

class BasicLLM(LLM):

    #Constructor, recibe modelo LLM y el token.   
    def __init__(self, model_llm, api_token):

        self.model_llm = model_llm
        self.api_token = api_token
    
    # Método obligado a implementar. 
    def generate_summary(self, text: str):

        #URL que le pasamos en el constructor. Nos es fija, depende del modelo que usemos, de ahí que usemos la variable al final. 
        url = f"https://router.huggingface.co/hf-inference/models/{self.model_llm}"

        # Cabeceras con el token
        headers =  {
                    "Authorization": f"Bearer {self.api_token}"
                    }

        #Payload, donde metemos el texto a resumir. 
        payload = { "inputs": text}
        
        #Petición POST
        response = requests.post(url, headers=headers, json=payload)

        try:
            result = response.json()
        except Exception:
            return f"La respuesta no es JSON válido. Código: {response.status_code}. Texto: {response.text}"
        #Devuelvo el resumen 
        print("Respuesta de la API:", result)
        if isinstance(result, list) and "summary_text" in result[0]:
            return result[0]["summary_text"]
        else:
            return f"Error en resumen: {result}"    