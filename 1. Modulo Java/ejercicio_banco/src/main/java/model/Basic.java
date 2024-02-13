package model;

import interfaces.ConsultaDeSaldo;
import interfaces.PagoDeServicios;
import interfaces.RetiroDeEfectivo;

public class Basic implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo {

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
        transaccionNoOk();
    }

    @Override
    public void pagarServicios(String tipoServ) {
        System.out.println("Pagando " + tipoServ + "...");
        transaccionOk();
    }

    @Override
    public void retirarEfectivo(Double monto) {
        System.out.println("Retirando " + monto + " en efectivo...");
        transaccionOk();
    }
}
