package org.example;

public class Basic extends Cliente implements ConsultaSaldo, PagoServicios, RetiroEfectivo{
    @Override
    public void RetirarEfectivo() {
        System.out.println("El Cliente Basic retira efectivo");
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
    public void ConsultarSaldo() {
        System.out.println("Saldo del Basic: 134894645");
    }
}
