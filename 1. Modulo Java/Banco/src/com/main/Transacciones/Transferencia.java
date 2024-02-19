package com.main.Transacciones;

public class Transferencia implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia correctamente realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar el Transferencia");
    }
}
