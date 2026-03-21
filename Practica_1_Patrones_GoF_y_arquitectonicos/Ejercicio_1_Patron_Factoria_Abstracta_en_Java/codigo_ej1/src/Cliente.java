import Factorias.FactoriaCasual;
import Factorias.FactoriaCompetitiva;
import Factorias.FactoriaPartidaYJugador;
import Partidas.Partida;

import java.util.Scanner;

/**
 * Clase principal que actúa como cliente del patrón Abstract Factory.
 * Se encarga de la interacción con el usuario, la creación de factorias,
 * la instanciación de partidas y jugadores, y la gestión de la ejecución
 * de forma concurrente.
 */
public class Cliente {
    public static void main(String[] args) {
        // Creamos las factorias
        FactoriaPartidaYJugador factoriaCasual = new FactoriaCasual();
        FactoriaPartidaYJugador factoriaCompetitiva = new FactoriaCompetitiva();

        // Pedimos el número de jugadores de la partida
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número de jugadores en una partida: ");
        while (!sc.hasNextInt()) {
            System.out.print("Eso no es un entero. Prueba otra vez: ");
            sc.next(); // descarta entrada inválida
        }

        int numJugadores = sc.nextInt();
        if (numJugadores <= 0) {
            System.out.println("El número de jugadores debe ser mayor que 0.");
            return;
        }

        System.out.println("Has introducido: " + numJugadores);

        sc.close();

        // Creamos las partidas
        Partida partCasual = factoriaCasual.crearPartida(numJugadores);
        Partida partComp = factoriaCompetitiva.crearPartida(numJugadores);

        // Creamos los jugadores
        for (int i = 0; i < numJugadores; i++) {
            partCasual.aniadirJugador(factoriaCasual.crearJugador(i));
            partComp.aniadirJugador(factoriaCompetitiva.crearJugador(i));
        }

        // Declaramos los hilos sobre las partidas
        Thread hiloCasual = new Thread(partCasual);
        Thread hiloComp = new Thread(partComp);

        // Arrancamos los hilos
        hiloCasual.start();
        hiloComp.start();

        try {
            hiloCasual.join();  // Espera que acabe la partida casual
            hiloComp.join();    // Espera que acabe la partida competitiva
        } catch (InterruptedException e) {
            System.out.println("Se ha interrumpido el hilo principal");
            Thread.currentThread().interrupt();
        }

        System.out.println("Programa finalizado");

    }
}
