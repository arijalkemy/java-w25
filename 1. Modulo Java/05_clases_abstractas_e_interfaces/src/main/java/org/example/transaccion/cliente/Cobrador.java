package org.example.transaccion.cliente;

import org.example.transaccion.transacciones.IConsultaSaldo;
import org.example.transaccion.transacciones.IRetiroEfectivo;

public class Cobrador extends Cliente implements IRetiroEfectivo, IConsultaSaldo {
    public Cobrador(String nombre) {
        super(nombre);
    }

    public void consultarSaldo() {
        IConsultaSaldo.super.consultarSaldo();
    }

    public void retirarEfectivo() {
        IRetiroEfectivo.super.retirarEfectivo();
    }
}
