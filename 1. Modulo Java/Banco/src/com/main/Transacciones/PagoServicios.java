package com.main.Transacciones;

public class PagoServicios implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago de Servicios correctamente realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar el pago de servicios");
    }
}
