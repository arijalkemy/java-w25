package org.example;

public class Deposito implements Transaccion{

    @Override
    public boolean transaccionOk() {
        System.out.println("Si se puede realizar operacion Deposito");
        return true;
    }

    @Override
    public boolean transaccionNoOk() {
        System.out.println("No se puede realizar operacion Deposito");
        return false;
    }
}
