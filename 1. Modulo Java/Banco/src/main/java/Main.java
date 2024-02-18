import cliente.*;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic("Juan");
        Cobrador cobrador = new Cobrador("Pepe");
        Ejecutivo ejecutivo = new Ejecutivo("Miguel");

        System.out.println("\n----------------------------");
        System.out.println("Basic:");
        basic.consultarSaldo();
        basic.retirarEfectivo();
        basic.pagarServicio();

        System.out.println("\n----------------------------");
        System.out.println("Cobrador:");
        cobrador.retirarEfectivo();
        cobrador.consultarSaldo();


        System.out.println("\n----------------------------");
        System.out.println("Ejecutivo:");
        ejecutivo.depositar();
        ejecutivo.transferir();
    }
}