package Partidas;

/**
 * Clase que representa una partida de modalidad competitiva.
 * Hereda de la clase abstracta Partida.
 * Tiene un porcentaje de abandono definido del 20%.
 */
public class PartidaCompetitiva extends Partida{
    /** Porcentaje de jugadores que abandonan la partida. */
    private static final int PORCENTAJE_ABANDONO = 20; // Es de un 20%

    /**
     * Constructor de la partida competitiva.
     * @param numJugadores Número inicial de jugadores.
     */
    public PartidaCompetitiva(int numJugadores) {
        super(numJugadores);
    }

    /**
     * Devuelve el porcentaje de abandono específico para partidas competitivas.
     * @return El porcentaje de abandono (20).
     */
    protected int getPorcentajeAbandono() {
        return PORCENTAJE_ABANDONO;
    }

    /**
     * Devuelve el nombre de la modalidad.
     * @return La cadena "competitiva".
     */
    protected String getModalidadPartida(){
        return "competitiva";
    }
}
