package Ejercicio1;

public class Ejecutivo extends Cliente implements ITransaccion , IDeposito, ITransferencia{
    @Override
    public void transaccionOk(){}

    @Override
    void transaccionNoOk(){}
}
