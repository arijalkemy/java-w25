package org.example.banco.transaccion;

public class Depositos implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito no realizado");
    }
}
