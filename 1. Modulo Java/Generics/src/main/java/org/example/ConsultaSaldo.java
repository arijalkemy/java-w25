package org.example;

public class ConsultaSaldo implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("La consulta se hizo con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La consulta no se hizo con exito");

    }
}
