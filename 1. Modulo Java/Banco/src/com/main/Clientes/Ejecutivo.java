package com.main.Clientes;

import com.main.Transacciones.ITransaccion;

public class Ejecutivo {
    public void realizarDeposito(ITransaccion transaccion) {
        transaccion.transaccionOk();
    }

    public void realizarTransferencia(ITransaccion transaccion) {
        transaccion.transaccionNoOk();
    }
}
