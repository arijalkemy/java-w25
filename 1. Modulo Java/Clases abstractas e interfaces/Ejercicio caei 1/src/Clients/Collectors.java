package Clients;

import Transactions.BalanceInquiry;
import Transactions.CashWithdrawal;

public class Collectors {
    public void withdrawCash() {
        new CashWithdrawal().transactionOk();
    }

    public void checkBalance() {
        new BalanceInquiry().transactionOk();
    }
}
