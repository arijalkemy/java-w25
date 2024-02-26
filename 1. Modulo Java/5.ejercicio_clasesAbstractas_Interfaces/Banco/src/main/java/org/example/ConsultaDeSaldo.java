package org.example;

public class ConsultaDeSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consulta De Saldo Realizada con Exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta De Saldo no Realizada");
    }
}
