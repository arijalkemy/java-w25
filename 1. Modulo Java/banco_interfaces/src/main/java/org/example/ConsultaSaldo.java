package org.example;

public class ConsultaSaldo implements ITransaccion{


    @Override
    public void transaccionOk() {
        System.out.println("Consulta realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta no realizada");

    }
}
