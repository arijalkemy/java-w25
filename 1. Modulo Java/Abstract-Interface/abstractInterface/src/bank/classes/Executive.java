package bank.classes;

import bank.interfaces.Deposit;
import bank.interfaces.Transfer;

public class Executive implements Deposit, Transfer {
    @Override
    public void makeDeposit() {
        System.out.println("Haciendo depósito...");
    }

    @Override
    public void transactionOk(String transactionType) {
        System.out.println("La transacción de tipo "+ transactionType + " fue exitosa");
    }

    @Override
    public void transactionNotOk(String transactionType) {
        System.out.println("La transacción de tipo "+ transactionType + " NO fue exitosa");
    }

    @Override
    public void makeTransfer() {
        System.out.println("Haciendo transferencia...");
    }
}
