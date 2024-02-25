package meliboot.transactions.implementations;

import meliboot.transactions.interfaces.ITransaction;

public class PaidForServices implements ITransaction {
    @Override
    public void transactionOk() {
        System.out.println("Realizándose pago de servicios");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("No sé realizó el  pago de servicios");
    }
}
