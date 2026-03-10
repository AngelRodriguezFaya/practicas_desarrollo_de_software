public class NotificadorSlack extends NotificadorOtro{
    public NotificadorSlack(Notificador notificador) {
        super(notificador);
    }
        @Override
        public String enviarMensaje() {
            return "Enviando SMS: " + super.enviarMensaje();
        }
}