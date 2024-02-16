package org.example.transaccion.transacciones;

import static java.lang.Math.random;

public interface ITransferencia extends ITransaccion {
    default void transferir() {
        System.out.println("Realizando transferencia...");
        if ((random() < 0.5))
            ITransaccion.super.transaccionOk();
        else
            ITransaccion.super.transaccionNoOk();
    };
}
