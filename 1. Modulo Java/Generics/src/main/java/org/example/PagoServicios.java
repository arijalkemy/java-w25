package org.example;

public class PagoServicios implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Se pago con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pago con exito");
    }
}
