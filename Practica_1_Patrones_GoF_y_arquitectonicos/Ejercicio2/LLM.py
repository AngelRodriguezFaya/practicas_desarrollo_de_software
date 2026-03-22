from abc import ABC, abstractmethod
#Clase abstracta para los modelos de lenguaje (LLM) que se utilizarán para generar resúmenes. 
# Define un método abstracto 'generate_summary' que debe ser implementado por cualquier clase que herede de LLM. Este método tomará un texto como entrada y devolverá un resumen del mismo.
class LLM(ABC):

    @abstractmethod
    def generate_summary(self, text: str):
        pass