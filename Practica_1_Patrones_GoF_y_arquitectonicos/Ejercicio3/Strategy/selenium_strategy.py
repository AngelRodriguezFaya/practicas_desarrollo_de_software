from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from scraping_strategy import ScrapingStrategy

class SeleniumStrategy(ScrapingStrategy):# De esta forma, decimos que seleniumStrategy es una clase que hereda de ScrapingStrategy, lo que significa que debe implementar el método extract_teams() definido en la clase base. Esto garantiza que cualquier instancia de SeleniumStrategy pueda ser utilizada como una estrategia de scraping dentro del contexto del scraper.

#Implementamos el método heredado de la clase padre, el cual se encarga de extraer los datos de los equipos utilizando Selenium. 
    def extract_teams(self):
        options = Options()
        options.add_argument("--headless") #Modo headless para que el navegador no se abra visualmente
        options.add_argument("--no-sandbox")# Esta opción es necesaria para ejecutar Chrome en entornos sin privilegios, como contenedores Docker.
        options.add_argument("--disable-dev-shm-usage") #Con esta opción, Chrome usará el sistema de archivos temporal en lugar de la memoria compartida, lo que puede ayudar a evitar problemas de memoria en entornos limitados.

        service = Service("/usr/bin/chromedriver") #La ruta del controlador de Chrome.
        driver = webdriver.Chrome(service=service, options=options)

        teams_data = []# Array para almacenar los datos de los equipos extraídos.

        for page in range(1, 6):#Bucle para iterar a través de las páginas del sitio web, asumiendo que hay 5 páginas de datos.
            url = f"https://www.scrapethissite.com/pages/forms/?page_num={page}"#Url del sitio web con el número de página dinámico.
            driver.get(url)

            rows = driver.find_elements("css selector", "tr.team")# Encontrar todas las filas de equipos en la página. En el html, cada equipo se representa como una fila de tabla con la clase "team".

            for row in rows: #Bucle para iterar a través de cada fila de equipo encontrada y extraer los datos utilizando selectores CSS para acceder a cada celda específica dentro de la fila. Luego, se crea un diccionario con los datos del equipo y se agrega a la lista teams_data.
                team_data = {
                    "Team Name": row.find_element("css selector", "td.name").text,
                    "Year": row.find_element("css selector", "td.year").text,
                    "Wins": row.find_element("css selector", "td.wins").text,
                    "Losses": row.find_element("css selector", "td.losses").text,
                    "OT Losses": row.find_element("css selector", "td.ot-losses").text,
                    "Win %": row.find_element("css selector", "td.pct").text,
                    "Goals For": row.find_element("css selector", "td.gf").text,
                    "Goals Against": row.find_element("css selector", "td.ga").text,
                    "+ / -": row.find_element("css selector", "td.diff").text,
                }
                teams_data.append(team_data)

        driver.quit()
        return teams_data # DEvuelve la lista de diccionarios con los datos de los equipos extraídos.