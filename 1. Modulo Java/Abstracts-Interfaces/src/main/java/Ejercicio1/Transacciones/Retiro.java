package Ejercicio1.Transacciones;

public class Retiro implements iTransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("ERROR: No se pudo realizar el retiro.");
    }
}
