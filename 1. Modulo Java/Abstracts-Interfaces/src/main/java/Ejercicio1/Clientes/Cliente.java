package Ejercicio1.Clientes;


import Ejercicio1.Transacciones.*;

public abstract class Cliente {
    Consulta opConsulta;
    Deposito opDeposito;
    Pago opPago;
    Retiro opRetiro;
    Transferencia opTransferencia;

    public Cliente() {
        this.opConsulta = new Consulta();
        this.opDeposito = new Deposito();
        this.opPago = new Pago();
        this.opRetiro = new Retiro();
        this.opTransferencia = new Transferencia();
    }

    public abstract void realizarConsulta();
    public abstract void realizarDeposito();
    public abstract void realizarPago();
    public abstract void realizarRetiro();
    public abstract void realizarTransferencia();
}
