package OpcionesBancarias;

public class PagoDeServicios implements ITransaccion {
    @Override
    public void trasaccionOk() {
        System.out.println("Se han pagado los servicios de manera correcta");
    }
}
