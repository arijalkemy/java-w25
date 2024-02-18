package Ejercicio1;

public class RetiroEnEfectivo implements ITransaccionable {
    @Override
    public void transaccionOk() {
        System.out.println("Se realizó el retiro en efectivo correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un error al realizar el retiro en efectivo.");
    }

}
