# Ejercicio 4. Patrón filtros de intercepción en Ruby.
***

Este ejercicio trata sobre un servicio de autenticación que requiere validar las credenciales de un usuario, formadas por una dirección de correo electrónico y una contraseña. Además se nos pide que no modifiquemos las clases existentes y que implementemos el patrón de filtros de intercepción. El **patrón de filtros de intercepción** es un patrón de comportamiento. Los **patrones conductuales (o de comportamiento)** son aquellos que definen la forma de cómo interactúan, se comunican y distribuyen responsabilidades los objetos y clases dentro de un sistema. Este patrón en concreto, sirve para interceptar y manipular una petición antes de que llegue a su destino final (o para modificar la respuesta antes de devolvérsela al cliente), que es lo que buscamos para implementar este servicio de autenticación.

## 1.- Diagrama de clases en UML.
***

![Diagrama de clases](./diagramas_UML/Diagrama%20de%20Clases1.png)

## 2.- Diagrama de secuencia en UML.
***

<div align="center">
  <img src="./diagramas_UML/Diagrama%20de%20Secuencia%20Ejercicio%204%20P1%20DS.png" alt="Diagrama de secuencia" width="1000px">
</div>


## 3.- Entorno de Desarrollo
***

Este proyecto ha sido desarrollado y probado utilizando las siguientes herramientas:
- **Sistema Operativo:** Ubuntu 24.04 LTS (Linux)
- **IDE:** RubyMine
- **Lenguaje:** Ruby


## 4.- Ejecución
***
Para ejecutar este proyecto desde la terminal, sitúate dentro del directorio `codigo_ej4` y ejecuta el siguiente comando:

```bash
$ ruby main.rb
```