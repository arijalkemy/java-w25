package meliboot.transactions.implementations;

import meliboot.transactions.interfaces.ITransaction;

public class Deposit implements ITransaction {
    @Override
    public void transactionOk() {
        System.out.println("Realizándose deposito");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("No sé realizó el deposito.");
    }
}





