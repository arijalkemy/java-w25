package org.example.model;

import org.example.interfaces.IDesposito;
import org.example.interfaces.ITransferencia;

public class Ejecutivo extends Cliente implements IDesposito, ITransferencia {

    private final String mensaje = "para usuario tipo ejecutivo";
    @Override
    public String depositar() {
        return "Depositando monto";
    }

    @Override
    public String transferir() {
        return "Transfiriendo monto";
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
