package org.example;

public class ReservaHotel extends Reserva {
    public ReservaHotel(double importe) {
        super(importe);
        this.nombre = "Hotel";
    }
}
