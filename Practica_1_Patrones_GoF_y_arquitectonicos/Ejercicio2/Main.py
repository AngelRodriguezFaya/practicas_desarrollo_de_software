import json

from BasicLLM import BasicLLM
from TranslationDecorator import TranslationDecorator
from SentimentDecorator import SentimentDecorator

def main():
    # Leemos del config.json los parámetros y los guardamos en variables para trabajar con ellos. 
    with open("config.json", "r", encoding="utf-8") as file:
        config = json.load(file)

    texto = config["texto"]
    model_llm = config["model_llm"]
    model_translation = config["model_translation"]
    model_sentiment = config["model_sentiment"]
    api_token = config["huggingface_api_token"]

    #Vamos a generar paso a paso cada uno de los resúmenes y resultados y mostrando por pantalla cada uno de ellos.
    # 1. LLM básico. Aquí simplemente creamos el objeto BasicLLM con el modelo y token, y llamamos a generate_summary para obtener el resumen básico.
    basic_llm = BasicLLM(model_llm, api_token)
    basic_summary = basic_llm.generate_summary(texto)

    # 2. Resumen traducido. Utilizamos el primer decorador, TranslationDecorator, que envuelve al BasicLLM. Al llamar a generate_summary, primero se obtiene el resumen básico y luego se traduce.
    translated_llm = TranslationDecorator(basic_llm, model_translation, api_token)
    translated_summary = translated_llm.generate_summary(texto)

    # 3. Resumen con sentimiento. Utilizamos el segundo decorador, SentimentDecorator, que también envuelve al BasicLLM. Al llamar a generate_summary, se obtiene el resumen básico y luego se analiza el sentimiento.
    sentiment_llm = SentimentDecorator(basic_llm, model_sentiment, api_token)
    sentiment_summary = sentiment_llm.generate_summary(texto)

    # 4. Combinación total: primero traducir, luego analizar sentimiento
    combined_llm = SentimentDecorator(
        TranslationDecorator(basic_llm, model_translation, api_token),
        model_sentiment,
        api_token
    )
    combined_summary = combined_llm.generate_summary(texto)

    # Mostrar resultados
    print("=== RESUMEN BÁSICO ===")
    print(basic_summary)
    print()

    print("=== RESUMEN TRADUCIDO ===")
    print(translated_summary)
    print()

    print("=== RESUMEN CON SENTIMIENTO ===")
    print(sentiment_summary)
    print()

    print("=== RESUMEN TRADUCIDO Y ANALIZADO ===")
    print(combined_summary)
    print()

    # Guardar resultados en fichero
    resultados = {
        "basic_summary": basic_summary,
        "translated_summary": translated_summary,
        "sentiment_summary": sentiment_summary,
        "combined_summary": combined_summary
    }

    with open("resultados.json", "w", encoding="utf-8") as file:
        json.dump(resultados, file, ensure_ascii=False, indent=4)


if __name__ == "__main__":
    main()