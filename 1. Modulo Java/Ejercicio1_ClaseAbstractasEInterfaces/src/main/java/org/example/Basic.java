package org.example;

import java.util.Random;

public class Basic {
    public void consultarSaldo (){
        Random random = new Random();
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        if (random.nextInt(2)==1){
            consultaSaldo.transaccionOk();
        }else {
            consultaSaldo.transaccionNoOk();
        }
    }
    public void pagoServicio (){
        Random random = new Random();
        PagoServicio pagoServicio = new PagoServicio();
        if (random.nextInt(2)==1){
            pagoServicio.transaccionOk();
        }else {
            pagoServicio.transaccionNoOk();
        }
    }
    public void retiroEfectivo (){
        Random random = new Random();
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        if (random.nextInt(2)==1){
            retiroEfectivo.transaccionOk();
        }else {
            retiroEfectivo.transaccionNoOk();
        }
    }

}
