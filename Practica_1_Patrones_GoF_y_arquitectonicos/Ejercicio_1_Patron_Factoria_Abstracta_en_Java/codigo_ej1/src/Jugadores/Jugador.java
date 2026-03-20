package Jugadores;

public abstract class Jugador {
    private final int id; // Identificador del Jugador

    public Jugador(int id){
        this.id = id;
    }

    public int getIdJugador() { return id; }
    
}
