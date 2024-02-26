package org.example.models;

import org.example.ConsultaDeSaldo;
import org.example.RetiroDeEfectivo;

public class Cobrador extends Cliente{
    RetiroDeEfectivo retiroDeEfectivo = new RetiroDeEfectivo();
    ConsultaDeSaldo consultaDeSaldo = new ConsultaDeSaldo();

    void realizarRetiroDeEfectivo(){
        retiroDeEfectivo.transaccionOk();
    }

    void realizarConsultaDeSaldo(){
        consultaDeSaldo.transaccionOk();
    }
    @Override
    void realizarTransaccion() {
        realizarConsultaDeSaldo();
        realizarRetiroDeEfectivo();
    }
}
