package OpcionesBancarias;

public class RetiroDeEfectivo implements ITransaccion {
    @Override
    public void trasaccionOk() {
        System.out.println("Retiro hecho correctamente");
    }
}
