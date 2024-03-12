package org.example;

public class ReservaComida extends Reserva{
    public ReservaComida(double importe) {
        super(importe);
        this.nombre = "Comida";
    }

}
