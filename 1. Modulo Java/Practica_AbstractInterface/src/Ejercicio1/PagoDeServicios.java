package Ejercicio1;

public class PagoDeServicios implements ITransaccionable {
    @Override
    public void transaccionOk() {
        System.out.println("Se realizó el pago de servicios correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un error al realizar el pago de servicios.");
    }
}
