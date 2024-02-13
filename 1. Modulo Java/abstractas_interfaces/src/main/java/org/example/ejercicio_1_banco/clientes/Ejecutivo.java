package org.example.ejercicio_1_banco.clientes;

import org.example.ejercicio_1_banco.transacciones.*;

public class Ejecutivo extends Cliente {

    public Ejecutivo(int id, String nombreCompleto, ConsultaSaldo consultaSaldo, Deposito deposito,
                     PagoServicios pagoServicios, RetiroEfectivo retiroEfectivo, Transferencia transferencia) {
        super(id, nombreCompleto, consultaSaldo, deposito, pagoServicios, retiroEfectivo, transferencia);
    }

    public Ejecutivo() {
    }

    @Override
    public void consultarSaldo() {
        super.getConsultaSaldo().transaccionNoOk();
    }

    @Override
    public void depositar() {
        super.getDeposito().transaccionOk();
    }

    @Override
    public void pagarServicios() {
        super.getPagoServicios().transaccionNoOk();
    }

    @Override
    public void retirarEfectivo() {
        super.getRetiroEfectivo().transaccionNoOk();
    }

    @Override
    public void transferir() {
        super.getTransferencia().transaccionOk();
    }
}
