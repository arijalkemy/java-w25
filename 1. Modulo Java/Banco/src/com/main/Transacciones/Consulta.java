package com.main.Transacciones;

public class Consulta implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo correctamente realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar la consulta de saldo");
    }
}
