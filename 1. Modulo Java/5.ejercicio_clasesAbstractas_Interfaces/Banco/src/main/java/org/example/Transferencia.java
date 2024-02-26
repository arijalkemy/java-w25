package org.example;

public class Transferencia implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Transferencia Realizada con Exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia no Realizada");
    }
}
