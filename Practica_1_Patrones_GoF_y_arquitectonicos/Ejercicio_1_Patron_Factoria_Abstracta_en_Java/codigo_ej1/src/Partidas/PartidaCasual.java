package Partidas;

/**
 * Clase que representa una partida de modalidad casual.
 * Hereda de la clase abstracta Partida.
 * Tiene un porcentaje de abandono definido del 10%.
 */
public class PartidaCasual extends Partida{
    /** Porcentaje de jugadores que abandonan la partida. */
    private static final int PORCENTAJE_ABANDONO = 10; // Es de un 10%

    /**
     * Constructor de la partida casual.
     * @param numJugadores Número inicial de jugadores.
     */
    public PartidaCasual(int numJugadores) {
        super(numJugadores);
    }

    /**
     * Devuelve el porcentaje de abandono específico para partidas casuales.
     * @return El porcentaje de abandono (10).
     */
    protected int getPorcentajeAbandono() {
        return PORCENTAJE_ABANDONO;
    }

    /**
     * Devuelve el nombre de la modalidad.
     * @return La cadena "casual".
     */
    protected String getModalidadPartida(){
        return "casual";
    }
}
