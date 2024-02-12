package org.example;

public class RetiroEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro de efectivo no realizado con exito");
    }
}
