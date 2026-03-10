public class NotificadorEmail implements Notificador{
    private String mensaje;
    public NotificadorEmail(String mensaje){
        this.mensaje = mensaje;
    }
    @Override
    public String enviarMensaje(){
        return mensaje;
    }
}