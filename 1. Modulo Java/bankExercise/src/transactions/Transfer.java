package transactions;

public class Transfer implements ITransaction{
    @Override
    public void transactionOk() {
        System.out.println("Transferencia exitosa");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Transferencia fallida");
    }
}
