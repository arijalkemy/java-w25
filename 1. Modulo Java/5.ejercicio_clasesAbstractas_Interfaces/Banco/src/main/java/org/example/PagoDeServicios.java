package org.example;

public class PagoDeServicios implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Pago De Servicios Realizado con Exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago De Servicios  no Realizado");
    }
}
