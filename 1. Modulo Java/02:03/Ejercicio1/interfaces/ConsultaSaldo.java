package interfaces;

public class ConsultaSaldo implements ITransacciones {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizada correctamente.");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La consulta de saldo no se pudo realizar.");
    }

}