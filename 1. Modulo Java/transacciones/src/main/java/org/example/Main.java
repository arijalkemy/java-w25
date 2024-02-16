package org.example;

import org.example.model.Basic;
import org.example.model.Cobrador;
import org.example.model.Ejecutivo;

public class Main {
    public static void main(String[] args) {

        Ejecutivo ejecutivo = new Ejecutivo();
        System.out.println(ejecutivo.depositar());
        System.out.println(ejecutivo.transferir());
        System.out.println(ejecutivo.transaccionOk());
        System.out.println(ejecutivo.transaccionNoOk());

        Basic basic = new Basic();
        System.out.println(basic.retirarEfectivo());
        System.out.println(basic.consultarSaldo());
        System.out.println(basic.pagarServicio());
        System.out.println(basic.transaccionOk());
        System.out.println(basic.transaccionNoOk());

        Cobrador cobrador = new Cobrador();
        System.out.println(cobrador.consultarSaldo());
        System.out.println(cobrador.retirarEfectivo());
        System.out.println(cobrador.transaccionOk());
        System.out.println(cobrador.transaccionNoOk());
    }
}