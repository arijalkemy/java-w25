import productos.Producto;

import java.util.ArrayList;

public class RepositorioReserva {
    private ArrayList<Reserva> reservas;

    public void crearReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public RepositorioReserva() {
        reservas = new ArrayList<Reserva>();
    }

    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }
}
