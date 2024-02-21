package org.example;

public class Transferencia implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("La transferencia se hizo con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transferencia no se hizo con exito");
    }
}
