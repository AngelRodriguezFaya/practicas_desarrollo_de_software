public abstract class NotificadorOtro implements Notificador{
    protected Notificador notificador;
    public NotificadorOtro(Notificador notificador){
        this.notificador = notificador;
    }
    @Override
    public String enviarMensaje(){
        return notificador.enviarMensaje();
    }
}