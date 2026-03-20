package Factorias;

import Jugadores.Jugador;
import Partidas.Partida;

/**
 * Interfaz Abstract Factory.
 * Define los métodos para crear familias de objetos relacionados (Partida y Jugador).
 */
public interface FactoriaPartidaYJugador {
    Partida crearPartida(int numJugadores);
    Jugador crearJugador(int id);
}
