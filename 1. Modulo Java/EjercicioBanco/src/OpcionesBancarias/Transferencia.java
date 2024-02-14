package OpcionesBancarias;

public class Transferencia implements ITransaccion {
    @Override
    public void trasaccionOk() {
        System.out.println("Transferencia realizada.");
    }
}
