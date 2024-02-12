package org.example.exercise1;

public class BalanceCheck implements ITransaction{
    @Override
    public void transaccionOk() {
        System.out.println("Consultando saldo");

    }
    @Override
    public void transaccionNoOk() {
        System.out.println("Error consultando saldo");
    }
}
