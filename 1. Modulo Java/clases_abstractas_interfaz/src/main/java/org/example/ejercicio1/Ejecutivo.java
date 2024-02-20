package org.example.ejercicio1;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {
    @Override
    public void transaccionOk() {
        System.out.println("Transaccion realizada con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no realizada con exito");
    }

    @Override
    public void realizarDeposito() {
        System.out.println("Realizando deposito...");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizando transferencia...");
    }
}
