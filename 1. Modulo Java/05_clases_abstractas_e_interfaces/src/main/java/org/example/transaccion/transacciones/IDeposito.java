package org.example.transaccion.transacciones;

import static java.lang.Math.random;

public interface IDeposito extends ITransaccion {
    default void depositar() {
        System.out.println("Realizando deposito...");
        if ((random() < 0.5))
            ITransaccion.super.transaccionOk();
        else
            ITransaccion.super.transaccionNoOk();
    }
}
