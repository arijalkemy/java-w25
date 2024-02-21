package Ejercicio_Clases_Abs_Int.src.Ejercicio1;

public class RetiroEnEfectivo implements ITransaccionable {
    public void transaccionOk() {
        System.out.println("Se realizó el retiro en efectivo correctamente.");
    }

    public void transaccionNoOk() {
        System.out.println("Hubo un error al realizar el retiro en efectivo.");
    }

}
