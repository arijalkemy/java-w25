package org.example;

import java.util.Random;

public class Ejecutivo {
    public void realizarTransferencia (){
        Random random = new Random();
        Transferencia transferencia1 = new Transferencia();
        if (random.nextInt(2)==1){
            transferencia1.transaccionOk();
        }else {
            transferencia1.transaccionNoOk();
        }
    }
    public void realizarDeposito (){
        Random random = new Random();
        Deposito deposito = new Deposito();
        if (random.nextInt(2)==1){
            deposito.transaccionOk();
        }else {
            deposito.transaccionNoOk();
        }
    }
}
