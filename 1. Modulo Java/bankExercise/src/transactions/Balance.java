package transactions;

public class Balance implements ITransaction{
    @Override
    public void transactionOk() {
        System.out.println("Consulta de saldo exitosa");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Consulta de saldo fallida");
    }
}
