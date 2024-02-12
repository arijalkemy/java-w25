package Ejercicio1.Transacciones;

public class Consulta implements iTransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizada.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("ERROR: No se pudo realizar la consulta de saldo");
    }
}
