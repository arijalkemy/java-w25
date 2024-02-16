package transactions;

public class Deposit implements ITransaction{
    @Override
    public void transactionOk() {
        System.out.println("Deposito exitoso");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Deposito fallido");
    }
}
