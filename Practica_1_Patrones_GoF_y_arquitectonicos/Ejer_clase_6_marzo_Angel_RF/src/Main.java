//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Notificador base = new Notificador(" Servidor Caido ");
        Notificador n1 = new NotificadorEmail(base);
        System.out.println(n1.enviarMensaje());

        Notificador n2 = new NotificadorSMS(base);
        System.out.println(n2.enviarMensaje());

        Notificador n3 = new NotificadorSlack(base);
        System.out.println(n3.enviarMensaje());
    }
}