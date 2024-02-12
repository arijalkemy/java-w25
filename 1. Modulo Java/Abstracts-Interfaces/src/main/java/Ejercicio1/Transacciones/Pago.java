package Ejercicio1.Transacciones;

public class Pago implements iTransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago del Sevicio realizado.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("ERROR: No se pudo realizar el pago del servicio.");
    }
}
