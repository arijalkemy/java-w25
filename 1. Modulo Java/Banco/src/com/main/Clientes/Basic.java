package com.main.Clientes;

import com.main.Transacciones.Consulta;
import com.main.Transacciones.ITransaccion;
import com.main.Transacciones.PagoServicios;
import com.main.Transacciones.Retiro;

public class Basic{
    public void realizarConsultaSaldo(Consulta transaccion){
        transaccion.transaccionOk();
    }
    public void realizarPagoServicios(PagoServicios transaccion){
        transaccion.transaccionNoOk();
    }
    public void relizarRetiroEfectivo(Retiro transaccion){
        transaccion.transaccionOk();
    }
}
