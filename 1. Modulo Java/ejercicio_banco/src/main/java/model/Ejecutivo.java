package model;

import interfaces.Deposito;
import interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void realizarDeposito() {
        System.out.println("Realizando deposito...");
        transaccionNoOk();
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizando transferencia...");
        transaccionOk();
    }
}
