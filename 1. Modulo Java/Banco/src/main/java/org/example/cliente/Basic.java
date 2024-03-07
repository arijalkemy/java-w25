package org.example.cliente;

import org.example.transacciones.IConsultaSaldo;
import org.example.transacciones.IPagoServicio;
import org.example.transacciones.IRetiroEfectivo;

public class Basic extends Cliente implements IPagoServicio, IConsultaSaldo, IRetiroEfectivo {

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
