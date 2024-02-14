package org.example;

public class Deposito implements ITransaccion{

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito no realizado");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado");
    }
}
