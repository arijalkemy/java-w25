package org.example.model;

import org.example.interfaces.IConsulta;
import org.example.interfaces.IRetiro;

public class Cobrador extends Cliente implements IRetiro, IConsulta {

    private final String mensaje = "para usuario tipo cobrador";
    @Override
    public String consultarSaldo() {
        return "Consultando el saldo";
    }

    @Override
    public String retirarEfectivo() {
        return "Retirando el efectivo";
    }

    @Override
    public String transaccionOk() {
        return super.transaccionOk() + mensaje;
    }

    @Override
    public String transaccionNoOk() {
        return super.transaccionNoOk() + mensaje;
    }
}
