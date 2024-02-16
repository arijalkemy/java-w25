package org.example.modelo;

public class ReservaComida extends Reserva{
    public ReservaComida (String detalle, double precio, int cantidad) {
        super(detalle, precio, cantidad);
    }

    @Override
    public String toString() {
        return "Reserva Comida " + super.toString();
    }

    
}
