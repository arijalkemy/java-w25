package org.bootcamp.ejercicio1;

public class Executive implements Deposit, Transfer{
    public Executive() {
    }

    @Override
    public void deposit() {
        System.out.println("Realizando deposito");
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
    public void transfer() {
        System.out.println("Realizando transferencia");
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
