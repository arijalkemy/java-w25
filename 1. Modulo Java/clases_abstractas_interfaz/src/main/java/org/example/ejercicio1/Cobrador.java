package org.example.ejercicio1;

public class Cobrador extends Cliente implements ConsultaSaldo, RetiroEfectivo {

    @Override
    public void consultarSaldo(){
        System.out.println("Consultando saldo...");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion realizada con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no realizada con exito");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo...");
    }

}
