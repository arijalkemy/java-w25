package Ejercicio_Clases_Abs_Int.src.Ejercicio1;

public class Deposito implements ITransaccionable {
    public void transaccionOk() {
        System.out.println("Se realizó el depósito correctamente.");
    }

    public void transaccionNoOk() {
        System.out.println("Hubo un error al realizar el depósito.");
    }
}
