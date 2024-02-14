package interfaces;

public class RetiroEfectivo implements ITransacciones {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado correctamente.");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar el retiro de efectivo.");
    }

}