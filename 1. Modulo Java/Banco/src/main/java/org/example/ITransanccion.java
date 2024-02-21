package org.example;

public interface ITransanccion {

    public void transaccionOk();
    default void transaccionNoOK(){
        System.out.println("transaccion no permitida");
    }
    void hacerDeposito();
    void hacerTransferencia();
    void hacerRetiro();
    void consultaSaldo();
    void pagoServicios();
    void retiroEfectivo();


}
