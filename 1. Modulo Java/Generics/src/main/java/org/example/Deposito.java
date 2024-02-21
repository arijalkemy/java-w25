package org.example;

public class Deposito implements ITransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("El deposito se realizo con exito");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El deposito no se realizo con exito");

    }


}
