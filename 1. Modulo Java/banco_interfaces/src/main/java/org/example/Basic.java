package org.example;

public class Basic {

    public Basic() {
    }


    public void consultaSaldo() {
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        consultaSaldo.transaccionOk();
        System.out.println("Consulta de saldo realizada");
    }

    public void retiroEfectivo() {
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        retiroEfectivo.transaccionOk();
        System.out.println("Retiro de efectivo realizado");
    }

    public void pagoServicio() {
        PagoServicio pagoServicio = new PagoServicio();
        pagoServicio.transaccionOk();
        System.out.println("Pago de servicio realizado");
    }
}
