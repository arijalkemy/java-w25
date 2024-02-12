package Ejercicio1.Transacciones;

public class Deposito implements iTransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Depósito realizado.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("ERROR: No se pudo realizar el depósito.");
    }
}
