package bank.classes;

import bank.interfaces.BalanceInquiry;
import bank.interfaces.CashWithdrawal;

public class Collector implements CashWithdrawal, BalanceInquiry {
    @Override
    public void getBalance() {
        System.out.println("Obteniendo balance...");
    }

    @Override
    public void makeWithdrawal(Double amount) {
        System.out.println("Haciendo retiro por un valor de $" + amount);
    }

    @Override
    public void transactionOk(String transactionType) {
        System.out.println("La transacción de tipo "+ transactionType + " fue exitosa");
    }

    @Override
    public void transactionNotOk(String transactionType) {
        System.out.println("La transacción de tipo "+ transactionType + " NO fue exitosa");
    }
}
