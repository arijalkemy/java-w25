package org.bootcamp.ejercicio1;

public class Basic implements BalanceCheck, PaymentService,Withdrawal{
    @Override
    public void balanceCheck() {
        System.out.println("Consultando saldo");
        getStatusTransaction();
    }

    @Override
    public void transaccionOK() {
        System.out.println("Transacción exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción fallida");
    }

    @Override
    public void payService() {
        System.out.println("Pagando servicio");
        getStatusTransaction();
    }

    @Override
    public void withdraw() {
        System.out.println("Realizando retiro");
        getStatusTransaction();
    }

    private void getStatusTransaction(){
        if(((int)(Math.random() * 2)) == 1){
            transaccionOK();
        }else{
            transaccionNoOk();
        }
    }
}
