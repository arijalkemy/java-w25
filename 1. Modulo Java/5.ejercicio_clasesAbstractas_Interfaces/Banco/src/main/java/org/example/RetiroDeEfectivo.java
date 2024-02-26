package org.example;

public class RetiroDeEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro De Efectivo Realizado con Exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro De Efectivo no Realizado");
    }
}
