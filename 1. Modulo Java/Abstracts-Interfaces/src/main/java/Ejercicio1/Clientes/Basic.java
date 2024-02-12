package Ejercicio1.Clientes;

public class Basic extends Cliente{

    @Override
    public void realizarConsulta() {
        opConsulta.transaccionOk();
    }

    @Override
    public void realizarDeposito() {
        opDeposito.transaccionNoOk();
    }

    @Override
    public void realizarPago() {
        opPago.transaccionOk();
    }

    @Override
    public void realizarRetiro() {
        opRetiro.transaccionOk();
    }

    @Override
    public void realizarTransferencia() {
        opTransferencia.transaccionNoOk();
    }
}
