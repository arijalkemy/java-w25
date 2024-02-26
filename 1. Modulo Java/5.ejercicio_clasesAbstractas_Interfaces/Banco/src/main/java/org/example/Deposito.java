package org.example;

public class Deposito implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Deposito Realizado con Exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito no Realizado");
    }
}
