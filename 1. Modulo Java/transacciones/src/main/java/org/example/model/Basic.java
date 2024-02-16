package org.example.model;

import org.example.interfaces.IConsulta;
import org.example.interfaces.IPago;
import org.example.interfaces.IRetiro;

public class Basic extends Cliente implements IRetiro, IConsulta, IPago {

    private final String mensaje = "para usuario tipo basic";
    @Override
    public String consultarSaldo() {
        return "Consulta de saldo";
    }

    @Override
    public String pagarServicio() {

        return "Pagando servicio";
    }

    @Override
    public String retirarEfectivo() {

        return "Retirando efectivo";
    }

    @Override
    public String transaccionNoOk() {
        return super.transaccionNoOk() + mensaje;
    }

    @Override
    public String transaccionOk() {
        return super.transaccionOk() + mensaje;
    }
}
