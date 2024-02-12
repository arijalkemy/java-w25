package Solucion2;

import java.util.List;

public class Localizador {
    Cliente cliente;
    Double total;
    List<Reserva> reservas;

    public Cliente getCliente() {
        return cliente;
    }

    public Double getTotal() {

        return total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void Imprimir(){
        System.out.println("Resumen del localizador \n Cliente: " + cliente
        + ", total: "+this.getTotal());

    }

     public double calcularTotal(){
        double total = 0;
        for (Reserva reserva : reservas){
            total += reserva.getPrecio();
        }
        this.total =total;
        return total;
    }

    public Localizador(Cliente cliente, Double total, List<Reserva> reservas) {
        this.cliente = cliente;
        this.total = total;
        this.reservas = reservas;
    }

    public void agregarReserva(Reserva reserva){
        this.reservas.add(reserva);
    }

}
