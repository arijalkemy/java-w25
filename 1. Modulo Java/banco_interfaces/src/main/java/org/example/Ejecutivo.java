package org.example;

public class Ejecutivo {

    public Ejecutivo(){

    }


    public void depositar() {
        Deposito deposito = new Deposito();
        deposito.transaccionOk();
        System.out.println("Deposito realizado");
    }
    public void transferir() {
        Transferencia transferencia = new Transferencia();
        transferencia.transaccionOk();
        System.out.println("Transferencia realizada");
    }



}
