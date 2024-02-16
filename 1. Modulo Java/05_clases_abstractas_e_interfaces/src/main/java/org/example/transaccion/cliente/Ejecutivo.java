package org.example.transaccion.cliente;

import org.example.transaccion.transacciones.IDeposito;
import org.example.transaccion.transacciones.ITransferencia;

public class Ejecutivo extends Cliente implements IDeposito, ITransferencia {
    public Ejecutivo(String nombre) {
        super(nombre);
    }

    public void depositar() {
        IDeposito.super.depositar();
    }

    public void transferir() {
        ITransferencia.super.transferir();
    }
}
