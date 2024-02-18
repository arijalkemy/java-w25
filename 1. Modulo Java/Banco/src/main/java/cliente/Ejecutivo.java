package cliente;

import transacciones.IDeposito;
import transacciones.ITransferencia;

public class Ejecutivo extends Cliente implements IDeposito, ITransferencia {

    public Ejecutivo(String nombre) {
        this.nombre = nombre;
    }
    public void depositar() {
        IDeposito.super.depositar();
    }

    public void transferir() {
        ITransferencia.super.transferir();
    }
}
