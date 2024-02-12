package org.example.banco.clientes;

import org.example.banco.transaccion.Depositos;
import org.example.banco.transaccion.Transaccion;
import org.example.banco.transaccion.Transferencia;


public class Ejecutivos {

    Transaccion deposito = new Depositos();

    Transaccion transferencia = new Transferencia();



    public void depositoOk(){
        deposito.transaccionOk();
    }
    public void depositoNoOk(){
        deposito.transaccionNoOk();
    }

    public void  transferenciaOk(){

        transferencia.transaccionOk();

    }

    public void  transferenciaNoOk(){

        transferencia.transaccionNoOk();

    }



}
