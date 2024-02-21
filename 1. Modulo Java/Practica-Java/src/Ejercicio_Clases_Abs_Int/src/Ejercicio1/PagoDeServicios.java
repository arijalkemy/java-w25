package Ejercicio_Clases_Abs_Int.src.Ejercicio1;

public class PagoDeServicios implements ITransaccionable {
    public void transaccionOk() {
        System.out.println("Se realizó el pago de servicios correctamente.");
    }

    public void transaccionNoOk() {
        System.out.println("Hubo un error al realizar el pago de servicios.");
    }
}
