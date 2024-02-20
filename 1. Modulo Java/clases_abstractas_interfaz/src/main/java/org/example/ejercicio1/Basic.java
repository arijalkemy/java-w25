package org.example.ejercicio1;

public class Basic extends Cliente implements ConsultaSaldo, PagoServicios, RetiroEfectivo {
    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion realizada con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no realizada con exito");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo");
    }

    @Override
    public void pagarServicio() {
        System.out.println("Pagando servicio...");
    }
}
