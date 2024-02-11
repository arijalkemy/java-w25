package org.example;

public class Basic extends Cliente implements IConsultaDeSaldo, IPagoDeServicio, IRetiroDeEfectivo{

    @Override
    public void consultarSaldo() {
        System.out.println("Su saldo es $" + super.getSaldoDisponible());
    }

    @Override
    public void pagarServicio() {
        System.out.println("Servicio abonado con éxito");
    }

    @Override
    public void retiroDeEfectivo() {
        System.out.println("Retirando efectivo");
    }
}
