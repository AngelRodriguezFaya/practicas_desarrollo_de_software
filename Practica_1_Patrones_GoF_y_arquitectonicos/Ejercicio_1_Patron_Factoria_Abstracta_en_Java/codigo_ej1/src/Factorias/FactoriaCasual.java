package Factorias;

import Jugadores.Jugador;
import Jugadores.JugadorCasual;
import Partidas.Partida;
import Partidas.PartidaCasual;

/**
 * Implementación concreta de la factoría abstracta para el modo casual.
 * Se encarga de crear partidas de tipo {@link PartidaCasual}
 * y jugadores de tipo {@link JugadorCasual}.
 */
public class FactoriaCasual implements FactoriaPartidaYJugador{

    /**
     * Crea una nueva partida casual.
     * @param numJugadores Número inicial de jugadores.
     * @return Una instancia de {@link PartidaCasual}.
     */
    public Partida crearPartida(int numJugadores) {
        return new PartidaCasual(numJugadores);
    }

    /**
     * Crea un nuevo jugador casual.
     * @param id Identificador único para el jugador.
     * @return Una instancia de {@link JugadorCasual}.
     */
     public Jugador crearJugador(int id) {
        return new JugadorCasual(id);
    }
}
