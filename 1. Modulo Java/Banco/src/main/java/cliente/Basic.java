package cliente;

import transacciones.IConsultaSaldo;
import transacciones.IPagoServicio;
import transacciones.IRetiroEfectivo;

public class Basic extends Cliente implements IPagoServicio, IConsultaSaldo, IRetiroEfectivo {

    public Basic(String nombre) {
        this.nombre = nombre;
    }

    public void consultarSaldo() {
        IConsultaSaldo.super.consultarSaldo();
    }

    public void retirarEfectivo() {
        IRetiroEfectivo.super.retirarEfectivo();
    }

    public void pagarServicio() {
        IPagoServicio.super.pagarServicio();
    }
}
