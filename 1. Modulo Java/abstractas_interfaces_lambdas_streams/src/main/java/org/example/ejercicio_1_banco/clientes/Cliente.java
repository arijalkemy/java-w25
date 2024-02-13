package org.example.ejercicio_1_banco.clientes;

import org.example.ejercicio_1_banco.transacciones.*;

public abstract class Cliente {
    private int id;
    private String nombreCompleto;
    private ConsultaSaldo consultaSaldo = new ConsultaSaldo();
    private Deposito deposito = new Deposito();
    private PagoServicios pagoServicios = new PagoServicios();
    private RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
    private Transferencia transferencia = new Transferencia();

    public Cliente(int id, String nombreCompleto, ConsultaSaldo consultaSaldo, Deposito deposito,
                   PagoServicios pagoServicios, RetiroEfectivo retiroEfectivo, Transferencia transferencia) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.consultaSaldo = consultaSaldo;
        this.deposito = deposito;
        this.pagoServicios = pagoServicios;
        this.retiroEfectivo = retiroEfectivo;
        this.transferencia = transferencia;
    }

    public Cliente() {
    }

    public ConsultaSaldo getConsultaSaldo() {
        return consultaSaldo;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public PagoServicios getPagoServicios() {
        return pagoServicios;
    }

    public RetiroEfectivo getRetiroEfectivo() {
        return retiroEfectivo;
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public abstract void consultarSaldo();

    public abstract void depositar();

    public abstract void pagarServicios();

    public abstract void retirarEfectivo();

    public abstract void transferir();
}
