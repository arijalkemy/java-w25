package Transactions;

public class Deposit implements Transaction{
    @Override
    public void transactionOk() {
        System.out.println("Deposito realizado exitosamente");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Error al hacer depósito");
    }
}
