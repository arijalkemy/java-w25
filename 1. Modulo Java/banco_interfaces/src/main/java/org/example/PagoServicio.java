package org.example;

public class PagoServicio implements ITransaccion{


    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicio realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicio no realizado");
    }
}
