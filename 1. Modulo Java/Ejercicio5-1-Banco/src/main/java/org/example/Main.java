package org.example;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        Ejecutivo ejecutivo = new Ejecutivo();
        Cobrador cobrador = new Cobrador();

        basic.consultarSaldo();
        basic.retirarEfectivo(24500);
        basic.pagarServicio("Servicios publicos");

        ejecutivo.depositarDinero(3500);
        ejecutivo.transferirDinero(4670);

        cobrador.consultarSaldo();
        cobrador.retirarEfectivo(31840);
    }
}