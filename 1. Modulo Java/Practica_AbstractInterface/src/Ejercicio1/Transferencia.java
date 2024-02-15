package Ejercicio1;

public class Transferencia implements ITransaccionable {
    @Override
    public void transaccionOk() {
        System.out.println("Se realizó la transferencia correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un error al realizar la transferencia.");
    }
}
