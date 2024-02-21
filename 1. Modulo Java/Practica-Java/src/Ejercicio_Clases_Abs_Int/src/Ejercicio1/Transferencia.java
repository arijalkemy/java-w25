package Ejercicio_Clases_Abs_Int.src.Ejercicio1;

public class Transferencia implements ITransaccionable {
    public void transaccionOk() {
        System.out.println("Se realizó la transferencia correctamente.");
    }

    public void transaccionNoOk() {
        System.out.println("Hubo un error al realizar la transferencia.");
    }
}
