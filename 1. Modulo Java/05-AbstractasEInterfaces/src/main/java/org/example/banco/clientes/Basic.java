package org.example.banco.clientes;

import org.example.banco.transaccion.ConsultaSaldo;
import org.example.banco.transaccion.PagoServicios;
import org.example.banco.transaccion.RetiroEfectivo;
import org.example.banco.transaccion.Transaccion;

public class Basic {

    Transaccion consultaSaldo = new ConsultaSaldo();
    Transaccion pagoServicios = new PagoServicios();

    Transaccion retiroEfectivo = new RetiroEfectivo();




    public void consultarSaldoOK(){
        consultaSaldo.transaccionOk();
    }
    public void consultarSaldoNoOK(){
        consultaSaldo.transaccionNoOk();
    }

    public void pagoServiciosOk(){
        pagoServicios.transaccionOk();
    }
    public void pagoServiciosNoOk(){
        pagoServicios.transaccionNoOk();
    }

    public void retiroEfectivoOk(){
        retiroEfectivo.transaccionOk();
    }

    public void retiroEfectivoNoOk(){
        retiroEfectivo.transaccionNoOk();
    }





}
