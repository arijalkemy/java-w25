package org.example.banco.clientes;

import org.example.banco.transaccion.ConsultaSaldo;
import org.example.banco.transaccion.PagoServicios;
import org.example.banco.transaccion.RetiroEfectivo;
import org.example.banco.transaccion.Transaccion;

public class Cobradores {

    Transaccion consultaSaldo = new ConsultaSaldo();
    Transaccion retiroEfectivo = new RetiroEfectivo();


    public void consultarSaldoOK(){
        consultaSaldo.transaccionOk();
    }
    public void consultarSaldoNoOK(){
        consultaSaldo.transaccionNoOk();
    }

    public void retiroEfectivoOk(){
        retiroEfectivo.transaccionOk();
    }

    public void retiroEfectivoNoOk(){
        retiroEfectivo.transaccionNoOk();
    }

}
