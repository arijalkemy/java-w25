package org.example.model;

import org.example.interfaces.ITransaccion;

public class Cliente implements ITransaccion {
    @Override
    public String transaccionOk() {
        return "Transaccion exitosa, ";
    }

    @Override
    public String transaccionNoOk() {
        return "Transaccion fallida, ";
    }
}
