package Transactions;

public class BalanceInquiry implements Transaction {
    @Override
    public void transactionOk() {
        System.out.println("Consulta de saldo realizada con exito");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Error al hacer la consulta de saldo");
    }
}
