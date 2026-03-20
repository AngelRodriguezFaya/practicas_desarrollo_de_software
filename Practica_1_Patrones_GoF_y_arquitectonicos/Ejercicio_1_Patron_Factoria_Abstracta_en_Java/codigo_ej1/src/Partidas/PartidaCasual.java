package Partidas;

public class PartidaCasual extends Partida{
    private static final int PORCENTAJE_ABANDONO = 10; // Es de un 10%

    public PartidaCasual(int numJugadores) {
        super(numJugadores);
    }

    protected int getPorcentajeAbandono() {
        return PORCENTAJE_ABANDONO;
    }

    protected String getModalidadPartida(){
        return "casual";
    }
}
