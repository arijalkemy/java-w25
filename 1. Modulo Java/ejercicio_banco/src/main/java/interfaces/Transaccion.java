package interfaces;

public interface Transaccion {
    default void transaccionOk(){
        System.out.println("Transacción exitosa");
    }
    default void transaccionNoOk(){
        System.out.println("Transacción fallida");
    }
}
