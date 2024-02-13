package model;

import interfaces.ConsultaDeSaldo;
import interfaces.RetiroDeEfectivo;

public class Cobrador implements RetiroDeEfectivo, ConsultaDeSaldo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
        transaccionOk();
    }

    @Override
    public void retirarEfectivo(Double monto) {
        System.out.println("Retirando " + monto + " en efectivo...");
        transaccionOk();
    }
}
