package org.example.ejercicio_1_banco.clientes;

import org.example.ejercicio_1_banco.transacciones.*;

public class Basic extends Cliente {

    public Basic(int id, String nombreCompleto, ConsultaSaldo consultaSaldo, Deposito deposito,
                 PagoServicios pagoServicios, RetiroEfectivo retiroEfectivo, Transferencia transferencia) {
        super(id, nombreCompleto, consultaSaldo, deposito, pagoServicios, retiroEfectivo, transferencia);
    }

    public Basic() {
    }

    @Override
    public void consultarSaldo() {
        super.getConsultaSaldo().transaccionOk();
    }

    @Override
    public void depositar() {
        super.getDeposito().transaccionNoOk();
    }

    @Override
    public void pagarServicios() {
        super.getPagoServicios().transaccionOk();
    }

    @Override
    public void retirarEfectivo() {
        super.getRetiroEfectivo().transaccionOk();
    }

    @Override
    public void transferir() {
        super.getTransferencia().transaccionNoOk();
    }
}
