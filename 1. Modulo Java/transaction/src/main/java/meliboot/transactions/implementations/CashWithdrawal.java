package meliboot.transactions.implementations;

import meliboot.transactions.interfaces.ITransaction;

public class CashWithdrawal implements ITransaction {
    @Override
    public void transactionOk() {
        System.out.println("Realizándose retiro de efectivo.");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("No sé realizó el retiro de efectivo");
    }
}
