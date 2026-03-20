package Factorias;

import Jugadores.Jugador;
import Jugadores.JugadorCasual;
import Partidas.Partida;
import Partidas.PartidaCasual;

public class FactoriaCasual implements FactoriaPartidaYJugador{

    public Partida crearPartida(int numJugadores) {
        return new PartidaCasual(numJugadores);
    }

     public Jugador crearJugador(int id) {
        return new JugadorCasual(id);
    }
}
