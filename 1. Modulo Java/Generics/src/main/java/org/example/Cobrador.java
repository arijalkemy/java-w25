package org.example;

public class Cobrador extends Cliente{
    ITransaccion retiroEfectivo = new RetiroEfectivo();
    ITransaccion consultaSaldo = new ConsultaSaldo();

    public void retiroEfectivo(boolean a){
        if(a) {
            retiroEfectivo.transaccionOk();
        }
        else{
            retiroEfectivo.transaccionNoOk();
        }
    }


}
