package org.example;

public class Main {
    public static void main(String[] args) {
        Ejecutivos ejecutivo1 = new Ejecutivos("Pablito", 12345);
        Cobradores cobrador1 = new Cobradores("Carlitos", 12300);
        Basic basic1 = new Basic("Santiago", 12340);

        ejecutivo1.realizarDepositos();
        ejecutivo1.realizarTransferencia();

        cobrador1.retirarEfectivo(1000);
        cobrador1.consultarSaldo();

        basic1.pagosServicios();
        basic1.retirarEfectivo(400);
        basic1.consultarSaldo();
        
    }
}