package interfaces;

import interfaces.Transacciones;

public interface Transferencia extends Transacciones {
    public void realizarTransferencia(double monto);
}
