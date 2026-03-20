package Factorias;

import Jugadores.Jugador;
import Jugadores.JugadorCompetitivo;
import Partidas.Partida;
import Partidas.PartidaCompetitiva;

public class FactoriaCompetitiva implements FactoriaPartidaYJugador{

    public Partida crearPartida(int numJugadores) {
        return new PartidaCompetitiva(numJugadores);
    }

     public Jugador crearJugador(int id) {
        return new JugadorCompetitivo(id);
    }
}
