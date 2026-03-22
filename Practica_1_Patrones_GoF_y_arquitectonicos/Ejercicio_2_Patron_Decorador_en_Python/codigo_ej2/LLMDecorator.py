from LLM import LLM

class LLMDecorator(LLM):
    def __init__(self, llm: LLM):
        self.llm = llm

    def generate_summary(self, text: str):
        return self.llm.generate_summary(text)