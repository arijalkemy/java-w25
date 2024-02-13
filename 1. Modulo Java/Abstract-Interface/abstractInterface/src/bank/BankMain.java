package bank;

import bank.classes.Basic;
import bank.classes.Collector;
import bank.classes.Executive;

public class BankMain {
    public static void main(String[] args) {
        Executive executive = new Executive();
        Basic basic = new Basic();
        Collector collector = new Collector();

        executive.makeTransfer();
        executive.transactionNotOk("Hacer depósito");

        basic.payService("Recibo de luz");
        basic.getBalance();

        collector.getBalance();
        collector.makeWithdrawal(24.00);
    }
}
