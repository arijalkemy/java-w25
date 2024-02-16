package transactions;

public class RetireCash implements ITransaction{
    @Override
    public void transactionOk() {
        System.out.println("Retiro exitoso");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Retiro fallido");
    }
}
