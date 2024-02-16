package org.example.modelo;

public class ReservaHotel extends Reserva{
    public ReservaHotel (String detalle, double precio, int cantidad) {
        super(detalle, precio, cantidad);
    }

    @Override
    public String toString() {
        return "Reserva Hotel [" + super.toString() + "]";
    }

    
}
