package org.example.exercise1;

public class Deposit implements ITransaction {
    @Override
    public void transaccionOk() {
        System.out.println("Realizando deposito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar el deposito");
    }
}
