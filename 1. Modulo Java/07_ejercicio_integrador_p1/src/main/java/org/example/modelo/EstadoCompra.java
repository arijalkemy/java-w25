package org.example.modelo;

public enum EstadoCompra {
    PENDIENTE(0), RECHAZADO(1), APROBADO(2);

    private final int numero;

    EstadoCompra(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return this.numero;
    }
}
