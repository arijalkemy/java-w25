package org.example.ejercicio_1_banco.transacciones;

import org.example.ejercicio_1_banco.interfaz.ITransaccion;

public class ConsultaSaldo implements ITransaccion {

    public ConsultaSaldo() {
    }

    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizada.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Fallo en consulta de saldo.");
    }
}
