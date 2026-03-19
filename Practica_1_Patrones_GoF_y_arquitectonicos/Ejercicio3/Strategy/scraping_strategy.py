from abc import ABC, abstractmethod
#Interfaz de estrategia que define el método de extracción de equipos. 
class ScrapingStrategy(ABC):

    @abstractmethod
    def extract_teams(self):
        pass