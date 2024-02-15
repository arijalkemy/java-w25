package Clients;

import Transactions.*;

public class Basic {

    public void checkBalance() {
        new BalanceInquiry().transactionOk();
    }

    public void servicePayment() {
        new ServicePayment().transactionOk();
    }
    public void withdrawCash() {
        new CashWithdrawal().transactionOk();
    }
}
