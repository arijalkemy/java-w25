package org.example;

public class Cobrador extends Cliente implements ConsultaSaldo, RetiroEfectivo {

    @Override
    public void ConsultarSaldo(){
        System.out.println("Saldo del Cobrador: 134894645");
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
    public void RetirarEfectivo() {
        System.out.println("El Cobrador retira efectivo");
    }
}
