package org.example;

public class Ejecutivo implements IDeposito, ITransferencia{
    @Override
    public void depositarDinero(double monto) {
        String tipoServicio = "Depositar dinero";
        if (monto > 0) {
            transaccionOK(tipoServicio);
        } else {
            transaccionNoOk(tipoServicio);
        }
    }

    @Override
    public void transaccionOK(String tipoServicio) {
        System.out.println("El proceso "+tipoServicio+" fue exitoso");
    }

    @Override
    public void transaccionNoOk(String tipoServicio) {
        System.out.println("Lo sentimos, no se pudo realizar el proceso "+tipoServicio);
    }

    @Override
    public void transferirDinero(double monto) {
        String tipoServicio = "Transferir dinero";
        if (monto > 0) {
            transaccionOK(tipoServicio);
        } else {
            transaccionNoOk(tipoServicio);
        }
    }
}
