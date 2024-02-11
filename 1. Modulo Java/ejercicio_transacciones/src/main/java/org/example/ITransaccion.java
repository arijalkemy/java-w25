package org.example;

public interface ITransaccion {
    default void transaccionOK(){
        System.out.println("Operación realizada con éxito");
    };
    default void transaccionNoOk(){
        System.out.println("No se pudo realizar la operación");
    };
}
