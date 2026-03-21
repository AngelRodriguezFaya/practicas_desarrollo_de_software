package Factorias;

import Jugadores.Jugador;
import Partidas.Partida;

/**
 * Interfaz Abstract Factory.
 * Define los métodos para crear familias de objetos relacionados (Partida y Jugador).
 * Permite cambiar la implementación de la creación de objetos sin modificar el código que los usa.
 */
public interface FactoriaPartidaYJugador {
    /**
     * Crea una instancia de una partida.
     * @param numJugadores Número inicial de jugadores para la partida.
     * @return Objeto Partida creado.
     */
    Partida crearPartida(int numJugadores);

    /**
     * Crea una instancia de un jugador.
     * @param id Identificador único para el jugador.
     * @return Objeto Jugador creado.
     */
    Jugador crearJugador(int id);
}
