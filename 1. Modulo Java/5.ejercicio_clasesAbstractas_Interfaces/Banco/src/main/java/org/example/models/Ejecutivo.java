package org.example.models;

import org.example.Deposito;
import org.example.Transaccion;
import org.example.Transferencia;

public class Ejecutivo extends Cliente{
    Deposito deposito = new Deposito();
    Transferencia transferencia = new Transferencia();

    void realizarDeposito(){
        deposito.transaccionOk();
    }

    void realizarTransferencia(){
        transferencia.transaccionOk();
    }

    @Override
    void realizarTransaccion() {
        realizarDeposito();
        realizarTransferencia();
    }
}
