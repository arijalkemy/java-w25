package org.example;

public class Basic implements IConsultaSaldo, IPagoServicio, IRetiroEfectivo{
    @Override
    public void retirarEfectivo(double monto) {
        String tipoServicio = "Retirar efectivo";
        if (monto > 0){
            transaccionOK(tipoServicio);
        } else {
            transaccionNoOk(tipoServicio);
        }
    }

    @Override
    public void pagarServicio(String tipoServicio) {
        if (tipoServicio != null){
            transaccionOK(tipoServicio);
        } else {
            transaccionNoOk(tipoServicio);
        }
    }

    @Override
    public void consultarSaldo() {
        String tipoServicio = "Consultar saldo";
        transaccionOK(tipoServicio);
        System.out.println("Su saldo es: ");
    }

    @Override
    public void transaccionOK(String tipoServicio) {
        System.out.println("El proceso "+tipoServicio+" fue exitoso");
    }

    @Override
    public void transaccionNoOk(String tipoServicio) {
        System.out.println("Lo sentimos, no se pudo realizar el proceso "+tipoServicio);
    }
}
