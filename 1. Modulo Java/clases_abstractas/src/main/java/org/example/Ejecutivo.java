package org.example;

public class Ejecutivo extends Cliente implements Deposito, Transferencia{
    @Override
    public void transaccionOk() {
        System.out.println("Transaccion realizada con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no realizada con exito");
    }
}
