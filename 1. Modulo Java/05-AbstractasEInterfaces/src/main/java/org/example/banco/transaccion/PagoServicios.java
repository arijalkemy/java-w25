package org.example.banco.transaccion;

public class PagoServicios implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicios fallido");
    }
}
