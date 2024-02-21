package entity;

import service.ITransaction;

public class CashWithdrawal implements ITransaction {
    public CashWithdrawal() {
        this.transactionOk();
    }

    @Override
    public void transactionOk() {
        System.out.println("Retiro de efectivo realizado con exito");
    }

    @Override
    public void transactionNotOk() {

    }
}
