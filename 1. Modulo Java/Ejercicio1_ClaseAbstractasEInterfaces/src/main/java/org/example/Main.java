package org.example;

public class Main {
    public static void main(String[] args) {

        Ejecutivo ejecutivo = new Ejecutivo();
        Cobrador cobrador = new Cobrador();
        Basic basic = new Basic();

        ejecutivo.realizarTransferencia();
        cobrador.consultaSaldo();
        basic.pagoServicio();

    }
}