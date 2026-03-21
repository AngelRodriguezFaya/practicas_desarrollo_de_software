package Jugadores;

/**
 * Clase abstracta que representa a un jugador genérico.
 * Contiene la información básica común a todos los jugadores, como su identificador.
 */
public abstract class Jugador {
    private final int id; // Identificador del Jugador

    /**
     * Constructor de la clase Jugador.
     * @param id El identificador único del jugador.
     */
    public Jugador(int id){
        this.id = id;
    }

    /**
     * Obtiene el identificador del jugador.
     * @return El ID del jugador.
     */
    public int getIdJugador() { return id; }
    
}
