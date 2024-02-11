package bootcamp.Models;

public class Reserva {
    private TipoReservasEnum tipoReserva;
    private double costo;

    public Reserva(TipoReservasEnum tipoReserva, double costo) {
        this.tipoReserva = tipoReserva;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public TipoReservasEnum getTipoReserva() {
        return tipoReserva;
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
