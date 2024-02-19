package com.main.Transacciones;

public class Deposito implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Deposito correctamente realizado");;
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar el deposito");
    }
}
