package org.example.ejercicio1;

public class ConsultaDeSaldo implements Itransaccion{
    @Override
    public void transaccionOK(){
        System.out.println("Se realizo la transaccion de manera exitosa");
    }
    @Override
    public void transaccionNoOk(){
        System.out.println("No se realizo la transaccion");
    }
}
