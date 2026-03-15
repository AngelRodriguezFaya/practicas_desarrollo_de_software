from abc import ABC, abstractmethod

class ScrapingStrategy(ABC):

    @abstractmethod
    def extract_teams(self):
        pass