package org.example.modelo;

public class ReservaTransporte extends Reserva{
    public ReservaTransporte (String detalle, double precio, int cantidad) {
        super(detalle, precio, cantidad);
    }

    @Override
    public String toString() {
        return "Reserva Transporte " + super.toString();
    }
    
}
