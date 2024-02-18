package transacciones;

public interface ITransaccion {
    default void transaccionOk() {
        System.out.println("Transaccion OK");
    }

    default void transaccionNoOk() {
        System.out.println("Transaccion NO OK");
    }
}
