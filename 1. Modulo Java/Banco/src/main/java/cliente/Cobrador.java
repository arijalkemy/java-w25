package cliente;

import transacciones.IConsultaSaldo;
import transacciones.IRetiroEfectivo;

public class Cobrador extends Cliente implements IRetiroEfectivo, IConsultaSaldo {

    public Cobrador(String nombre) {
        this.nombre = nombre;
    }
    public void consultarSaldo() {
        IConsultaSaldo.super.consultarSaldo();
    }

    public void retirarEfectivo() {
        IRetiroEfectivo.super.retirarEfectivo();
    }
}
