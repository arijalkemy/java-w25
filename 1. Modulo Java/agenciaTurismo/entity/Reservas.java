package org.clase08_02_24.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservas {
    long id;
    Double precio;
    DetalleReserva detalleReserva;
    int cantidad;

    private double getPrecio(DetalleReserva detalleReserva){
        switch (detalleReserva){
            case HOTEL -> {
                return 100.0;
            }
            case COMIDA -> {
                return 20.0;
            }
            case TRANSPORTE -> {
                return 55.0;
            }
            case BOLETO_VIAJE -> {
                return  120.0;
            }
            case PAQUETE_COMPLETO -> {
                return 295;
            }
            default -> {
                return 0;
            }
        }
    }
    public Reservas(long id, DetalleReserva detalleReserva, int cantidad) {

        this.id = id;
        this.precio = getPrecio(detalleReserva);
        this.detalleReserva = detalleReserva;
        this.cantidad = cantidad;
    }
}
