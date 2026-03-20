package Partidas;

public class PartidaCompetitiva extends Partida{
    private static final int PORCENTAJE_ABANDONO = 20; // Es de un 20%

    public PartidaCompetitiva(int numJugadores) {
        super(numJugadores);
    }

    protected int getPorcentajeAbandono() {
        return PORCENTAJE_ABANDONO;
    }

    protected String getModalidadPartida(){
        return "competitiva";
    }
}
