# Contexto que utiliza la estrategia para extraer equipos.
#Definimos, método para establecer estrategia y método para extraer equipos utilizando la estrategia actual. 
#Con esto, obtenemos mucha flexibilidad a la hora de cambiar la estrategia de extracción de datos sin necesidad de modificar el código del contexto. 
class HockeyScraperContext:

    def __init__(self, strategy):
        self.strategy = strategy

    def set_strategy(self, strategy):
        self.strategy = strategy

    def extract_teams(self):
        return self.strategy.extract_teams()