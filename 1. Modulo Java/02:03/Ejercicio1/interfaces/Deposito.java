package interfaces;

public class Deposito implements ITransacciones {
    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado correctamente.");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar el deposito.");
    }

}