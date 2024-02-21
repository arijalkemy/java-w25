package org.example.exercise1;

public class Transfer implements ITransaction{

    @Override
    public void transaccionOk() {
        System.out.println("Se realizo la transferencia!");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia no realizada!");
    }
}
