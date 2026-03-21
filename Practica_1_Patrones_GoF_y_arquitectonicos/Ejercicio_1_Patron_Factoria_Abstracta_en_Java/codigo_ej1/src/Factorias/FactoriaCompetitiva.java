package Factorias;

import Jugadores.Jugador;
import Jugadores.JugadorCompetitivo;
import Partidas.Partida;
import Partidas.PartidaCompetitiva;

/**
 * Implementación concreta de la factoría abstracta para el modo competitivo.
 * Se encarga de crear partidas de tipo {@link PartidaCompetitiva}
 * y jugadores de tipo {@link JugadorCompetitivo}.
 */
public class FactoriaCompetitiva implements FactoriaPartidaYJugador{

    /**
     * Crea una nueva partida competitiva.
     * @param numJugadores Número inicial de jugadores.
     * @return Una instancia de {@link PartidaCompetitiva}.
     */
    public Partida crearPartida(int numJugadores) {
        return new PartidaCompetitiva(numJugadores);
    }

    /**
     * Crea un nuevo jugador competitivo.
     * @param id Identificador único para el jugador.
     * @return Una instancia de {@link JugadorCompetitivo}.
     */
     public Jugador crearJugador(int id) {
        return new JugadorCompetitivo(id);
    }
}
