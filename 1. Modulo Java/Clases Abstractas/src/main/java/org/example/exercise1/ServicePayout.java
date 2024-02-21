package org.example.exercise1;

public class ServicePayout implements ITransaction {
    @java.lang.Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicio: La transacción no está OK. :(");
    }

    @java.lang.Override
    public void transaccionOk() {
        System.out.println("Pago de servicio: La trasacción se realizó con éxisto (transacción OK)");

    }
}
