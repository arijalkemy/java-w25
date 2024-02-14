import entity.Basic;
import entity.DebtCollector;
import entity.Executive;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        DebtCollector debtCollector = new DebtCollector();
        Executive executive = new Executive();

        basic.checkBalance();
        debtCollector.withdrawalCash();
        executive.makeTransfer();
    }
}
