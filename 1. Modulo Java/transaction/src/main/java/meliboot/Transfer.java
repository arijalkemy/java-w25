package meliboot;

import meliboot.transactions.interfaces.ITransaction;

public class Transfer implements ITransaction {
    @Override
    public void transactionOk() {
        System.out.println("Realizándose transferencia");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("No sé realizó la transferencia.");
    }
}
