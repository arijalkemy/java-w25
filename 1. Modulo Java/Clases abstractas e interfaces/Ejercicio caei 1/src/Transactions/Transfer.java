package Transactions;

public class Transfer implements Transaction{
    @Override
    public void transactionOk() {
        System.out.println("Transferencia realizada con éxito");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Error al hacer la transferencia");
    }
}
