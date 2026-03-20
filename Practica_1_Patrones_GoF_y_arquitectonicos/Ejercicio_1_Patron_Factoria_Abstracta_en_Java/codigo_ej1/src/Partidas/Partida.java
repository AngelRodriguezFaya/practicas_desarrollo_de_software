package Partidas;
import Jugadores.Jugador;

import java.util.ArrayList;
import java.util.Random;

public abstract class Partida implements Runnable{
    // Atributos
    private static final int DURACION_PARTIDA = 6000;   // en milisegundos = 60 segundos
    private ArrayList<Jugador> jugadores;       // Lista de jugadores en la partida
    private final Random rand = new Random();   // Para generar números aleatorios

    // Constructor
    public Partida(int numJugadores){
        this.jugadores = new ArrayList<>(numJugadores); // Reservamos memoria para numJugadores
    }

    // Métodos abstractos
    protected abstract int getPorcentajeAbandono();
    protected abstract String getModalidadPartida();

    // Métodos públicos
    public int getNumJugadores(){ return jugadores.size(); }

    public void aniadirJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    public boolean eliminarJugadorRandom(){
        boolean eliminado = false;

        if (! jugadores.isEmpty()){
            int indice = rand.nextInt(jugadores.size());
            int idJugador = jugadores.get(indice).getIdJugador();

            jugadores.remove(indice);
            eliminado = true;

            System.out.println("Jugador " + idJugador + " eliminado de la partida "
                    +getModalidadPartida());

        } else {
            System.out.println("No hay jugadores para eliminar");
        }

        return eliminado;
    }

    public void eliminarVariosJugadores(int nroEliminados){
        int eliminadosReales = 0; // Puede ser distinto de nroEliminados
        for(int i = 0; i < nroEliminados; i++){
            if (eliminarJugadorRandom()) {
                eliminadosReales++;
            }
        }

        System.out.println("Se han eliminado " + eliminadosReales + " jugadores de la partida "
                + getModalidadPartida());
    }

    @Override
    public void run(){

        try {
            System.out.println("\n----- Se ha inciado la partida " + getModalidadPartida()
                    + " con " + getNumJugadores() + " jugadores -----");

            int numAbandonos = (getNumJugadores() * getPorcentajeAbandono()) / 100;

            Thread.sleep(DURACION_PARTIDA/2);   // Esperamos la mitad del tiempo de la partida

            eliminarVariosJugadores(numAbandonos); // Eliminamos el número de jugadores que corresponden.

            Thread.sleep(DURACION_PARTIDA/2);   // Esperamos la otra mitad del tiempo

            System.out.println("----- Partida " + getModalidadPartida()
                    + " finalizada. Jugadores que han terminado la partida: "
                    + getNumJugadores() +" -----\n");

        } catch (InterruptedException e) {
            System.out.println("Se ha interrumpido la ejecución de la partida " + getModalidadPartida());
            // Restaurar el estado de interrupción por buenas prácticas
            Thread.currentThread().interrupt();
        }
    }
}
