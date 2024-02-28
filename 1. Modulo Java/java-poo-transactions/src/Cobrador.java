public class Cobrador implements IRetiroEfectivo, IConsultaSaldo{

    @Override
    public void realizarConsultaSaldo() {
        System.out.println("Realizando consulta de saldo");
    }

    @Override
    public void realizarRetiroEfectivo() {
        System.out.println("Realizando retiro efectivo");
    }

    @Override
    public void transactionOk() {

    }

    @Override
    public void transactionOkNo() {

    }
}
