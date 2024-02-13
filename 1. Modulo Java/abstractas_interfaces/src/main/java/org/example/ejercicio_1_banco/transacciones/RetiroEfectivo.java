package org.example.ejercicio_1_banco.transacciones;

import org.example.ejercicio_1_banco.interfaz.ITransaccion;

public class RetiroEfectivo implements ITransaccion {

    public RetiroEfectivo() {
    }

    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo en retiro de efectivo.");
    }
}
