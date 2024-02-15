package org.example.cliente;

import org.example.transacciones.IConsultaSaldo;
import org.example.transacciones.IRetiroEfectivo;

public class Cobrador extends Cliente implements IRetiroEfectivo, IConsultaSaldo {
    public void consultarSaldo() {
        IConsultaSaldo.super.consultarSaldo();
    }

    public void retirarEfectivo() {
        IRetiroEfectivo.super.retirarEfectivo();
    }
}
