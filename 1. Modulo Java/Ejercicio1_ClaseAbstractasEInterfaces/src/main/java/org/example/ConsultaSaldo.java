package org.example;

public class ConsultaSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo no realizado con exito");
    }
}
