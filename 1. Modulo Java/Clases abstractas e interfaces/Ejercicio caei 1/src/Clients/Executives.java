package Clients;

import Transactions.Deposit;
import Transactions.Transfer;

public class Executives {
    public void makeDeposit() {
        new Deposit().transactionOk();
    }

    public void makeTransfer() {
        new Transfer().transactionOk();
    }
}
