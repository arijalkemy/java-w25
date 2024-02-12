package org.example;

import java.util.Random;

public class Cobrador {

    public void retiroEfectivo (){
        Random random = new Random();
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        if (random.nextInt(2)==1){
            retiroEfectivo.transaccionOk();
        }else {
            retiroEfectivo.transaccionNoOk();
        }
    }
    public void consultaSaldo (){
        Random random = new Random();
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        if (random.nextInt(2)==1){
            consultaSaldo.transaccionOk();
        }else {
            consultaSaldo.transaccionNoOk();
        }
    }
}
