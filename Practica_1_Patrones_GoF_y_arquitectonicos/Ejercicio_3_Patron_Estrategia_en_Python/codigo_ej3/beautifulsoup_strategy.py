#Imports necesario para realizar la extracción de datos utilizando BS.
import csv
import requests
from bs4 import BeautifulSoup as BS
from scraping_strategy import ScrapingStrategy


class BeautifulSoupStrategy(ScrapingStrategy):# De esta forma, decimos que beautifulSoupStrategy es una clase que hereda de ScrapingStrategy, lo que significa que debe implementar el método extract_teams() definido en la clase base. Esto garantiza que cualquier instancia de BeautifulSoupStrategy pueda ser utilizada como una estrategia de scraping dentro del contexto del scraper.

    def extract_teams(self):#Método implementado para extraer los datos de los equipos utilizando BeautifulSoup. 
        teams_data = []

        for page in range(1, 6):#Bucle que itera sobre las 6 páginas del sitio web, construyendo la URL para cada página y realizando una solicitud HTTP para obtener el contenido de la página. 
            url = f"https://www.scrapethissite.com/pages/forms/?page_num={page}"
            response = requests.get(url)
            soup = BS(response.text, "html.parser")

            rows = soup.find_all("tr", class_="team")# Encontrar todas las filas de equipos en la página. En el html, cada equipo se representa como una fila de tabla con la clase "team".

            for row in rows:
                team_data = { #Bucle para iterar a través de cada fila de equipo encontrada y extraer los datos utilizando selectores CSS para acceder a cada celda específica dentro de la fila. Luego, se crea un diccionario con los datos del equipo y se agrega a la lista teams_data.
                    "Team Name": row.find("td", class_="name").get_text(strip=True),
                    "Year": row.find("td", class_="year").get_text(strip=True),
                    "Wins": row.find("td", class_="wins").get_text(strip=True),
                    "Losses": row.find("td", class_="losses").get_text(strip=True),
                    "OT Losses": row.find("td", class_="ot-losses").get_text(strip=True),
                    "Win %": row.find("td", class_="pct").get_text(strip=True),
                    "Goals For": row.find("td", class_="gf").get_text(strip=True),
                    "Goals Against": row.find("td", class_="ga").get_text(strip=True),
                    "+ / -": row.find("td", class_="diff").get_text(strip=True),
                }
                teams_data.append(team_data)

        return teams_data

