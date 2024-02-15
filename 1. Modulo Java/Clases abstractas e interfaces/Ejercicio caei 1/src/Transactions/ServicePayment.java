package Transactions;

public class ServicePayment implements Transaction{
    @Override
    public void transactionOk() {
        System.out.println("Pago de servicios exitoso");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Error al hacer pago de servicios");
    }
}
