package org.example;

public class RetiroEfectivo implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("El retiro se hizo con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El retiro no se hizo con exito");

    }

    public void retirar(boolean a ){
        if(a){transaccionOk();}
        else {transaccionNoOk();
    }}


}
