package org.example;

public class Cobrador {

    public Cobrador(){

    }

    public void retiroEfectivo() {
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        retiroEfectivo.transaccionOk();
        System.out.println("Retiro de efectivo realizado");
    }

    public void consultaSaldo() {
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        consultaSaldo.transaccionOk();
        System.out.println("Consulta de saldo realizada");
    }
}
