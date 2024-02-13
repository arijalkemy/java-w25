package org.example.ejercicio_1_banco.transacciones;

import org.example.ejercicio_1_banco.interfaz.ITransaccion;

public class PagoServicios implements ITransaccion {

    public PagoServicios() {
    }

    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios realizado.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo en pago de servicios.");
    }
}
