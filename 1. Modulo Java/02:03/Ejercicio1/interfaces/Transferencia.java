package interfaces;

public class Transferencia implements ITransacciones {
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada correctamente.");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar la transferencia.");
    }

}