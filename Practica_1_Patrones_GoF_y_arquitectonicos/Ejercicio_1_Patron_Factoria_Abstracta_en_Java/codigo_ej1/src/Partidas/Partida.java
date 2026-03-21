package Partidas;
import Jugadores.Jugador;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase abstracta que representa una partida genérica.
 * Implementa la interfaz Runnable para poder ejecutarse en un hilo independiente.
 * Gestiona la lista de jugadores y la lógica de eliminación durante la partida.
 */
public abstract class Partida implements Runnable{
    // Atributos
    private static final int DURACION_PARTIDA = 6000;   // en milisegundos = 60 segundos
    private ArrayList<Jugador> jugadores;       // Lista de jugadores en la partida
    private final Random rand = new Random();   // Para generar números aleatorios

    // Constructor
    /**
     * Constructor de la partida.
     * Inicializa la lista de jugadores con la capacidad indicada.
     *
     * @param numJugadores Número inicial de jugadores que tendrá la partida.
     */
    public Partida(int numJugadores){
        this.jugadores = new ArrayList<>(numJugadores); // Reservamos memoria para numJugadores
    }

    // Métodos abstractos
    /**
     * Obtiene el porcentaje de abandono específico para el tipo de partida.
     *
     * @return El porcentaje de jugadores que abandonarán la partida (10 o 20).
     */
    protected abstract int getPorcentajeAbandono();

    /**
     * Obtiene el nombre de la modalidad de la partida.
     *
     * @return Una cadena con el nombre de la modalidad (ej. "casual", "competitiva").
     */
    protected abstract String getModalidadPartida();

    // Métodos públicos
    /**
     * Obtiene el número actual de jugadores en la partida.
     *
     * @return El número de jugadores restantes.
     */
    public int getNumJugadores(){ return jugadores.size(); }

    /**
     * Añade un jugador a la partida.
     *
     * @param jugador El objeto Jugador a añadir.
     */
    public void aniadirJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    /**
     * Elimina un jugador aleatorio de la partida.
rre     * Si la lista de jugadores no está vacía, selecciona uno al azar y lo elimina.
     *
     * @return true si se eliminó un jugador, false si no había jugadores para eliminar.
     */
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

    /**
     * Elimina múltiples jugadores de la partida de forma aleatoria.
     * Llama internamente a {@link #eliminarJugadorRandom()} el número de veces especificado.
     *
     * @param numEliminados El número de jugadores a intentar eliminar.
     */
    public void eliminarVariosJugadores(int numEliminados){
        int eliminadosReales = 0; // Puede ser distinto de numEliminados
        for(int i = 0; i < numEliminados; i++){
            if (eliminarJugadorRandom()) {
                eliminadosReales++;
            }
        }

        System.out.println("\nSe han eliminado " + eliminadosReales + " jugadores de la partida "
                + getModalidadPartida() + "\n");
    }

    /**
     * Metodo principal de ejecución del hilo de la partida.
     * Simula el transcurso de la partida:
     * 1. Espera la mitad de la duración.
     * 2. Elimina un porcentaje de jugadores según la modalidad.
     * 3. Espera el resto de la duración.
     * 4. Finaliza la partida.
     */
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
