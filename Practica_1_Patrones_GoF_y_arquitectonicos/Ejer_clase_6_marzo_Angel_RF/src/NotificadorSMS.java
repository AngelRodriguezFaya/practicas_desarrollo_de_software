public class NotificadorSMS extends NotificadorOtro{
    public NotificadorSMS(Notificador notificador) {
        super(notificador);
    }
        @Override
        public String enviarMensaje() {
            return "Enviando SMS: " + super.enviarMensaje();
        }
}