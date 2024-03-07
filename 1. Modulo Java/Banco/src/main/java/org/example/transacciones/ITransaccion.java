package org.example.transacciones;

public interface ITransaccion {
    default void transaccionOk() {
        System.out.println("Transaccion Ok");
    }

    default void transaccionNoOk() {
        System.out.println("Transaccion No Ok");
    }
}
