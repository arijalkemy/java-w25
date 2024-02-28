public class Ejecutivo implements IDeposito, ITransferencia {

    @Override
    public void realizarDeposito() {
        System.out.println("Realizando deposito...");
    }

    @Override
    public void transactionOk() {

    }

    @Override
    public void transactionOkNo() {

    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizando transferencia...");
    }
}
