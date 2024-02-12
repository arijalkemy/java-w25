package Ejercicio1.Clientes;

public class Ejecutivo extends Cliente{
    @Override
    public void realizarConsulta() {
        opConsulta.transaccionNoOk();
    }

    @Override
    public void realizarDeposito() {
        opDeposito.transaccionOk();
    }

    @Override
    public void realizarPago() {
        opPago.transaccionNoOk();
    }

    @Override
    public void realizarRetiro() {
        opRetiro.transaccionNoOk();
    }

    @Override
    public void realizarTransferencia() {
        opTransferencia.transaccionOk();
    }
}
