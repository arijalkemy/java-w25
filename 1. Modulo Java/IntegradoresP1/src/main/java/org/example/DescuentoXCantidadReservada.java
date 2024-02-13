package org.example;

public class DescuentoXCantidadReservada implements Descuento{

    private TipoReserva tipo; // ej: HOTEL
    private int cantindad; // 2
    private double PORCENTAJE_DESCUENTO;

    @Override
    public double aplicarDescuento(double total) {
        return total * (1 - PORCENTAJE_DESCUENTO);
    }

}
