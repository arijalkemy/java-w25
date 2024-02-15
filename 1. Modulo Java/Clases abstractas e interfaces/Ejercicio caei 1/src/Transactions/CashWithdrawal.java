package Transactions;

public class CashWithdrawal implements Transaction{
    @Override
    public void transactionOk() {
        System.out.println("Retiro de efectivo realizado exitosamente");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Error al hacer retiro de efectivo");
    }
}
