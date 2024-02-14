package OpcionesBancarias;

public class ConsultaDeSaldo implements ITransaccion {
    @Override
    public void trasaccionOk() {
        System.out.println("Se ha consultado el saldo correctamente");
    }
}
