package entity;

import service.ITransaction;

public class Transfer implements ITransaction {
    public Transfer() {
        this.transactionNotOk();
    }

    @Override
    public void transactionOk() {
        System.out.println("Transferencia realizada con exito");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Ha ocurrido un error a realizar la transferencia");
    }
}
