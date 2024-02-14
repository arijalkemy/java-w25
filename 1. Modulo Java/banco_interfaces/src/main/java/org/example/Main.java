package org.example;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        basic.consultaSaldo();
        basic.retiroEfectivo();
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.depositar();
        ejecutivo.transferir();
        Cobrador cobrador = new Cobrador();
        cobrador.retiroEfectivo();
        cobrador.consultaSaldo();

    }
}