package org.example.modelo;

public class ReservaBoleto extends Reserva {
    public ReservaBoleto(String detalle, double precio, int cantidad) {
        super(detalle, precio, cantidad);
    }

    @Override
    public String toString() {
        return "Reserva Boleto " + super.toString();
    }
}
