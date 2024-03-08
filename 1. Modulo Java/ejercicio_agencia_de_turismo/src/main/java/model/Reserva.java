package model;

public class Reserva {
    private double precio;
    private Paquete paqueteReservado;

    public Reserva( Paquete paqueteReservado, double precio) {
        this.precio = precio;
        this.paqueteReservado = paqueteReservado;
    }

    public double getPrecio() {
        return precio;
    }


    public Paquete getPaqueteReservado() {
        return paqueteReservado;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "precio=" + precio +
                ", paqueteReservado=" + paqueteReservado +
                '}';
    }
}
