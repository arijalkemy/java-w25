package org.example;

public class ConsultaSaldo implements Transaccion{
    @Override
    public boolean transaccionOk() {
        return false;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }
}
