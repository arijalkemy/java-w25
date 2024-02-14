package classes;

import interfaces.*;

public class Ejecutivo {
    private String nombreCompleto;
    private Transferencia transferencia;
    private Deposito deposito;

    public Ejecutivo(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        this.transferencia = new Transferencia();
        this.deposito = new Deposito();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public Deposito getDeposito() {
        return deposito;
    }

}
