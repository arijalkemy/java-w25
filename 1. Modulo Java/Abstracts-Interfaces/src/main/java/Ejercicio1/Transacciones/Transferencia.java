package Ejercicio1.Transacciones;

public class Transferencia implements iTransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("ERROR: No se pudo realizar la transferencia.");
    }
}
