package org.example.cliente;

import org.example.transacciones.IDeposito;
import org.example.transacciones.ITransferencia;

public class Ejecutivo extends Cliente implements IDeposito, ITransferencia {
    public void depositar() {
        IDeposito.super.depositar();
    }

    public void transferir() {
        ITransferencia.super.transaccionNoOk();
    }
}
