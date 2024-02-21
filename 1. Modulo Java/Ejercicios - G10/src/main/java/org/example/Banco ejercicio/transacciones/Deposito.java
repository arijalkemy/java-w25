package org.example.ejercicio_1_banco.transacciones;

import org.example.ejercicio_1_banco.interfaz.ITransaccion;

public class Deposito implements ITransaccion {

    public Deposito() {
    }

    @Override
    public void transaccionOk() {
        System.out.println("Depósito realizado.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo en depósito.");
    }
}
