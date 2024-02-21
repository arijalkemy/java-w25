package entity;

import service.ITransaction;

public class ServicesPay implements ITransaction {
    public ServicesPay() {
        this.transactionOk();
    }

    @Override
    public void transactionOk() {
        System.out.println("Pago de servicios realizado con exito");
    }

    @Override
    public void transactionNotOk() {

    }
}
