package org.example.models;

import org.example.ConsultaDeSaldo;
import org.example.PagoDeServicios;
import org.example.RetiroDeEfectivo;

public class Basic extends Cliente{
    ConsultaDeSaldo consultaDeSaldo = new ConsultaDeSaldo();
    PagoDeServicios pagoDeServicios = new PagoDeServicios();
    RetiroDeEfectivo retiroDeEfectivo = new RetiroDeEfectivo();

    void realizarConsultaDeSaldo(){
        consultaDeSaldo.transaccionOk();
    }
    void realizarPagoDeServicios(){
        pagoDeServicios.transaccionOk();
    }
    void realizaRetiroDeEfectivo(){
        retiroDeEfectivo.transaccionOk();
    }
    @Override
    void realizarTransaccion() {
        realizarConsultaDeSaldo();
        realizaRetiroDeEfectivo();
        realizarPagoDeServicios();
    }
}
