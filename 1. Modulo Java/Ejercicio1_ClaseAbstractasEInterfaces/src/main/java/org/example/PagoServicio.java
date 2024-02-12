package org.example;

public class PagoServicio implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicio realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicio no realizado con exito");
    }
}
