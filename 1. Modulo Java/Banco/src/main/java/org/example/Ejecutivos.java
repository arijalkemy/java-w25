package org.example;

public class Ejecutivos extends Cliente{

    public Ejecutivos(String nombre, double saldo) {
        super(nombre, saldo);
    }

    public void realizarDepositos(){
        System.out.println("Realizar depósito");
    }

    public void realizarTransferencia(){
        System.out.println("Realizar transferencia");
    }

}
