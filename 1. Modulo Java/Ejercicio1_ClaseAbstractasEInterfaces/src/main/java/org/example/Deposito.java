package org.example;

public class Deposito implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito no realizado con exito");
    }
}
