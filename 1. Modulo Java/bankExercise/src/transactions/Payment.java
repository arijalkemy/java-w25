package transactions;

public class Payment implements ITransaction{
    @Override
    public void transactionOk() {
        System.out.println("Pago exitoso");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Pago fallido");
    }
}
