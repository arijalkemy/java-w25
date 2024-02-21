package entity;

import service.ITransaction;

public class Deposit implements ITransaction {
    public Deposit() {
        this.transactionOk();
    }

    @Override
    public void transactionOk() {
        System.out.println("Deposito realizado con exito");
    }

    @Override
    public void transactionNotOk() {

    }
}
