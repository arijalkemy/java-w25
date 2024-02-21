package org.example;

public class Ejecutivo implements ITransanccion {



    @Override
    public void transaccionOk() {
        System.out.println("transaccion exitosa");
    }



    @Override
    public void hacerDeposito() {
        System.out.println("realizando deposito...");
        transaccionOk();

    }

    @Override
    public void hacerTransferencia() {
        System.out.println("realizando transferencia...");
        transaccionOk();
    }



    @Override
    public void consultaSaldo() {

    }

    @Override
    public void pagoServicios() {

    }

    @Override
    public void retiroEfectivo() {

    }


}
