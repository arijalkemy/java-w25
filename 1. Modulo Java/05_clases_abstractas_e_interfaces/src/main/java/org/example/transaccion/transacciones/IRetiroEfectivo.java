package org.example.transaccion.transacciones;

import static java.lang.Math.random;

public interface IRetiroEfectivo extends ITransaccion{
    default void retirarEfectivo() {
        System.out.println("Retirando efectivo...");
        if ((random() < 0.5))
            ITransaccion.super.transaccionOk();
        else
            ITransaccion.super.transaccionNoOk();
    };
}
