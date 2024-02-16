package org.example.transaccion.cliente;

import org.example.transaccion.transacciones.IConsultaSaldo;
import org.example.transaccion.transacciones.IPagoServicio;
import org.example.transaccion.transacciones.IRetiroEfectivo;

public class Basico extends Cliente implements IPagoServicio, IConsultaSaldo, IRetiroEfectivo {
    public Basico(String nombre) {
        super(nombre);
    }

    public void consultarSaldo() {
        IConsultaSaldo.super.consultarSaldo();
    }

    public void retirarEfectivo() {
        IRetiroEfectivo.super.retirarEfectivo();
    }

    public void pagarServicio() {
        IPagoServicio.super.pagarServicio();
    }
}
