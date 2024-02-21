package Ejercicio_Clases_Abs_Int.src.Ejercicio1;

public class ConsultaDeSaldo  implements ITransaccionable {
    public void transaccionOk() {
        System.out.println("Se consultó el saldo correctamente.");
    }

    public void transaccionNoOk() {
        System.out.println("Hubo un error al consultar el saldo.");
    }
}
