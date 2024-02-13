package bank.classes;

import bank.interfaces.BalanceInquiry;
import bank.interfaces.CashWithdrawal;
import bank.interfaces.ServicePayment;

public class Basic implements BalanceInquiry, ServicePayment, CashWithdrawal {
    @Override
    public void getBalance() {
        System.out.println("Obteniendo balance...");
    }

    @Override
    public void makeWithdrawal(Double amount) {
        System.out.println("Haciendo retiro por un valor de $"+ amount);
    }

    @Override
    public void payService(String serviceType) {
        System.out.println("Haciendo pago al servicio " + serviceType);
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
