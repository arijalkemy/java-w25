package org.example.transaccion.transacciones;

import static java.lang.Math.random;

public interface IPagoServicio extends ITransaccion{
    default void pagarServicio() {
        System.out.println("Pagando servicio...");
        if ((random() < 0.5))
            ITransaccion.super.transaccionOk();
        else
            ITransaccion.super.transaccionNoOk();
    };
}
