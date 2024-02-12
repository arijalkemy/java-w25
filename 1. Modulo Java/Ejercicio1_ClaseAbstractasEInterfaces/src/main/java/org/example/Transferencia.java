package org.example;

public class Transferencia implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito no realizada con exito");
    }
}
