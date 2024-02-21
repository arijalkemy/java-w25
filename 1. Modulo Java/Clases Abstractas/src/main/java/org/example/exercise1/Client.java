package org.example.exercise1;

import java.util.List;

public abstract class Client {
    private List<ITransaction> transactionList;

    protected Client(List<ITransaction> transactionList) {
        this.transactionList = transactionList;
    }

    public List<ITransaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<ITransaction> transactionList) {
        this.transactionList = transactionList;
    }

    public <T extends ITransaction> void makeTransactionOk(T transaction) {
        transaction.transaccionOk();
    }
    public <T extends ITransaction> void makeTransactionNotOk(T transaction) {
        transaction.transaccionNoOk();
    }
}
