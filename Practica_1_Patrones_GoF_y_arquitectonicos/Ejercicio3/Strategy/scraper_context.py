class HockeyScraperContext:

    def __init__(self, strategy):
        self.strategy = strategy

    def set_strategy(self, strategy):
        self.strategy = strategy

    def extract_teams(self):
        return self.strategy.extract_teams()