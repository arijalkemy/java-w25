package org.example.ejercicio_1_banco.transacciones;

import org.example.ejercicio_1_banco.interfaz.ITransaccion;

public class Transferencia implements ITransaccion {

    public Transferencia() {
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo en transferencia.");
    }
}
