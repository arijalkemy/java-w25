package bootcamp.interfaz.ejercicio1;

public class Main {
    public static void main(String[] args) {
        Client edgar = new Client();
        Collector bork = new Collector();
        Executive rika = new Executive();

        edgar.checkBalance();

        rika.deposit();

        bork.collectFee();
    }
}
