import clients.Basic;
import clients.Client;
import clients.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.Deposit();

        Client basic = new Basic();
        basic.getBalance();
    }
}