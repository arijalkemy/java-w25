package meliboot.transactions.implementations;

import meliboot.transactions.interfaces.ITransaction;

public class BalanceQuery implements ITransaction {
    @Override
    public void transactionOk() {
        System.out.println("Realizándose pago de consulta de saldo");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("No sé realizó la consulta de saldos");
    }
}
