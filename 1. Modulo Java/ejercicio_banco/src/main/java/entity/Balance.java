package entity;

import service.ITransaction;

public class Balance implements ITransaction {
    public Balance() {
        this.transactionOk();
    }

    @Override
    public void transactionOk() {
        System.out.println("Consulta de balance realizada con exito");
    }

    @Override
    public void transactionNotOk() {

    }
}
