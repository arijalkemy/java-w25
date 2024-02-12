package org.example.banco.transaccion;

public class RetiroEfectivo implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo exitoso");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro de efectivo fallido");
    }
}
