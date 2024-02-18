package Ejercicio1;

public class ConsultaDeSaldo  implements ITransaccionable {
    @Override
    public void transaccionOk() {
        System.out.println("Se consultó el saldo correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un error al consultar el saldo.");
    }
}
