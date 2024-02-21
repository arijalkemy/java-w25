package main.java.com.bootcamp.model;

public class Reserva {
    private TipoReserva tipoReserva;
    private  double costo;

    public Reserva(TipoReserva tipoReserva, double costo) {
        this.tipoReserva = tipoReserva;
        this.costo = costo;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "tipoReserva=" + tipoReserva +
                ", costo=" + costo +
                '}';
    }
}
