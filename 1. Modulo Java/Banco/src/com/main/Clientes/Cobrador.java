package com.main.Clientes;

import com.main.Transacciones.ITransaccion;

public class Cobrador {
    public void relizarRetiroEfectivo(ITransaccion transaccion){
        transaccion.transaccionOk();
    }
    public void realizarConsultaSaldo(ITransaccion transaccion){
        transaccion.transaccionOk();
    }
}
