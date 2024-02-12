import paquetes.PaqueteTuristico;
import productos.*;

import java.util.ArrayList;
import java.util.Objects;

public class Reserva {
    private Cliente cliente;
    private PaqueteTuristico paquete;
    private double total;

    public Reserva(Cliente cliente, PaqueteTuristico paquete, RepositorioReserva reservas) {
        this.cliente = cliente;
        this.paquete = paquete;
        this.total = paquete.getPrecio();

        // verificar si ya tiene 2 reservas y hacer descuento
        int acc = 0;
        if (reservas.getReservas() != null) {
            for (Reserva res : reservas.getReservas()) {
                if (Objects.equals(res.getCliente().getDni(), cliente.getDni())) acc++;
            }
        }
        if (acc >= 2) total = total * 0.95;

        // verificar si reservo paquete completo
        acc = 0;
        int accComida = 0;
        int accBoleto = 0;
        int accTransporte =0;
        if (paquete.getProductos() != null) {
            for (Producto prod : paquete.getProductos()) {
                if (prod instanceof Hotel) acc++;
                if (prod instanceof Comida) accComida++;
                if (prod instanceof BoletoViaje) accBoleto++;
                if (prod instanceof Transporte) accTransporte++;
            }
        }
        if (acc >= 1 && accComida >= 1 && accBoleto >= 1 && accTransporte >= 1) {
            total = total * 0.90;
        }

        // verificar si tiene 2 reservas de hotel o 2 boletos
        acc = 0;
        accBoleto = 0;
        if (paquete.getProductos() != null) {
            for (Producto prod : paquete.getProductos()) {
                if (prod instanceof Hotel) acc++;
                if (prod instanceof BoletoViaje) accBoleto++;
            }
        }
        if (acc >= 2 || accBoleto >= 2) total = total * 0.95;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPaquete(PaqueteTuristico paquete) {
        this.paquete = paquete;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public PaqueteTuristico getPaquete() {
        return paquete;
    }

    public double getTotal() {
        return total;
    }
}
