package org.example;

public class Transferencia implements Transaccion{
    @Override
    public boolean transaccionOk() {
        return false;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }
}
