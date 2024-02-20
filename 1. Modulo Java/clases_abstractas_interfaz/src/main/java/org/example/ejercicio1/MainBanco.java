package org.example.ejercicio1;

public class MainBanco {
    public static void main(String[] args) {

        Basic basic = new Basic();
        basic.retirarEfectivo();
        basic.consultarSaldo();
        basic.pagarServicio();
        basic.transaccionOk();
        basic.transaccionNoOk();

        System.out.println("==============");

        Ejecutivo ejec = new Ejecutivo();
        ejec.realizarDeposito();
        ejec.realizarTransferencia();
        ejec.transaccionNoOk();
        ejec.transaccionOk();

        System.out.println("==============");

        Cobrador cobrador = new Cobrador();
        cobrador.retirarEfectivo();
        cobrador.consultarSaldo();
        cobrador.transaccionOk();
        cobrador.transaccionNoOk();


    }
}
