package org.example.transaccion.transacciones;

import static java.lang.Math.random;

public interface IConsultaSaldo extends ITransaccion{
    default void consultarSaldo() {
        System.out.println("Consultando saldo...");
        if ((random() < 0.5))
            ITransaccion.super.transaccionOk();
        else
            ITransaccion.super.transaccionNoOk();
    }
}
