import csv

from scraper_context import HockeyScraperContext
from beautifulsoup_strategy import BeautifulSoupStrategy
from selenium_strategy import SeleniumStrategy

#Main que ejecuta el programa, permitiendo al usuario elegir entre las dos estrategias de scraping (BeautifulSoup o Selenium) y luego utilizando la estrategia seleccionada para extraer los datos de los equipos de hockey. 
# Finalmente, los datos extraídos se guardan en un archivo CSV llamado "hockey_stats.csv".
def save_to_csv(data, filename="hockey_stats.csv"):
    if not data:
        print("No hay datos para guardar.")
        return

    fieldnames = [
        "Team Name",
        "Year",
        "Wins",
        "Losses",
        "OT Losses",
        "Win %",
        "Goals For",
        "Goals Against",
        "+ / -"
    ]

    with open(filename, "w", newline="", encoding="utf-8") as f:
        writer = csv.DictWriter(f, fieldnames=fieldnames)
        writer.writeheader()
        writer.writerows(data)

    print(f"Datos guardados en {filename}")


def choose_strategy():
    print("Selecciona la estrategia de scraping:")
    print("1. BeautifulSoup")
    print("2. Selenium")

    option = input("Introduce una opción (1 o 2): ").strip()

    if option == "1":
        return BeautifulSoupStrategy()
    elif option == "2":
        return SeleniumStrategy()
    else:
        return None


def main():
    strategy = choose_strategy()

    if strategy is None:
        print("Opción no válida.")
        return

    scraper = HockeyScraperContext(strategy)

    data = scraper.extract_teams()

    print(f"Total equipos extraídos: {len(data)}")
    print("Primeros 2 registros:")
    print(data[:2])

    save_to_csv(data)


if __name__ == "__main__":
    main()