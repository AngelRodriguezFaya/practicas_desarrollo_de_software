# Ejercicio 1. Patrón Factoría Abstracta en Java.

En este ejercicio teníamos que implementar un **sistema que simulase dos partidas multijugador y simultáneas**, con el mismo número de jugadores, a determinar en tiempo de ejecución (lo introduce el usuario al principio). Para ello debíamos utilizar hebras, haciendo uso de la interfaz *Runnable*. 

Las partidas tienen algunas características, como las modalidades (Competitiva y Casual) y la tasa de abandonos (en el caso de la partida Competitiva sería de un 20 % del total de jugadores, mientras que para la modalidad Casual sería de un 10 % del total de jugadores). Ambas partidas tienen una duración de 60 segundos y los abandonos de jugadores se producen al mismo tiempo. 

Para este ejercicio tenemos que implementar el patrón Factoría Abstracta, que es un patrón creacional. Los patrones creacionales son aquellos que implementan mecanismos de creación de objetos aumentando la flexibilidad y reutilización del código. El patrón **Factoría Abstracta** nos permite producir familias de objetos relacionados y dependientes sin especificar sus clases concretas, es decir, funciona como una fábrica de fábricas, donde se encapsula la creación de los productos y se garantiza la compatibilidad entre ellos. Eso es justo lo que necesitamos para este ejercicio, pues necesitamos crear partidas y jugadores de la misma modalidad, y no mezclarlos. 

## 1.- Diagrama de clases en UML.

![Diagrama de clases](./diagrama_de_clases/DC%20EJ1%20P1%20DS.png)


## 2.- Entorno de Desarrollo

Este proyecto ha sido desarrollado y probado utilizando las siguientes herramientas:
- **Sistema Operativo:** Ubuntu 24.04 LTS (Linux)
- **IDE:** IntelliJ IDEA
- **Lenguaje:** Java


## 3.- Compilación y Ejecución
Para compilar y ejecutar este proyecto desde la terminal, sitúate dentro del directorio `codigo_ej1` y utiliza los siguientes comandos:


### 3.1.- Compilar el código
Los archivos compilados `.class` se guardarán en la carpeta `bin/`.

```bash
$ mkdir -p bin && javac -d bin -sourcepath src src/Cliente.java
```

### 3.2.- Ejecutar el código
Ejecuta el siguiente comando:

```bash
$ java -cp bin/ Cliente
```


## 4. Generar la documentación (Javadoc)

Para crear o actualizar la documentación en formato HTML del proyecto, sitúate en el directorio `codigo_ej1` y ejecuta el siguiente comando:

```bash
javadoc -d docs -sourcepath src src/Cliente.java src/Factorias/*.java src/Jugadores/*.java src/Partidas/*.java
```

Una vez ejecutado, encontrarás la documentación en el directorio `docs`.  Puedes abrir el archivo `docs/index.html en cualquier navegador web para navegar por la documentación de las clases y métodos.