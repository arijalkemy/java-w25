package org.example;

public class Cobrador extends Cliente implements IRetiroDeEfectivo, IConsultaDeSaldo {

    @Override
    public void retiroDeEfectivo(){
        System.out.println("Retirando efectivo");
    };

    @Override
    public void consultarSaldo(){
        System.out.println("Su saldo es $xxxx");
    };

}
