package org.example.model;

import java.util.HashMap;
import java.util.List;

public class Localizador {
    private List<Reserva> reservas;
    private Cliente cliente;
    private double precioTotal;

    public Localizador() {
    }

    public Localizador( Cliente cliente, List<Reserva> reservas) {
        this.reservas = reservas;
        this.cliente = cliente;
        calcularPrecioTotal();
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "reservas=" + reservas +
                ", cliente=" + cliente +
                ", precioTotal=" + precioTotal +
                '}';
    }

    private void calcularPrecioTotal() {
        for (Reserva reserva : reservas) {
            precioTotal += reserva.getPrecio();
        }
        // Verificación descuento por paquete completo

        if(descuentoPaqueteCompleto())  precioTotal *= 0.90; //Descuento 10%

        //Verificacion descuento por reserva de 2 hotel y 2 boleto de viaje
        if(descuentoPorPaquete(Paquete.HOTEL)){
           double valor =  this.reservas.stream()
                    .filter(reserva -> reserva.getPaqueteReservado().equals(Paquete.HOTEL))
                    .mapToDouble(reserva -> reserva.getPrecio() * 0.05) //Descuento 5%
                   .sum();
             precioTotal -= valor;
        }
        if(descuentoPorPaquete(Paquete.BOLETOS_VIAJE)){
            double valor =  this.reservas.stream()
                    .filter(reserva -> reserva.getPaqueteReservado().equals(Paquete.BOLETOS_VIAJE))
                    .mapToDouble(reserva -> reserva.getPrecio() * 0.05) //Descuento 5%
                    .sum();
             precioTotal -= valor;
        }

    }

    private boolean descuentoPaqueteCompleto(){
        int contadorTodosTipos = 0;

        for (Paquete tipoPaquete : Paquete.values()) {
            for (Reserva reserva : this.reservas) {
                if (reserva.getPaqueteReservado().equals(tipoPaquete)) contadorTodosTipos++;
                break;
            }
        }
        return contadorTodosTipos == 4;
    }
    private boolean descuentoPorPaquete(Paquete paquete){
        HashMap<Paquete, Integer> contadorPaquetes = new HashMap<>();
        for (Reserva reserva : reservas){
            if( contadorPaquetes.putIfAbsent(reserva.getPaqueteReservado(), 1) != null)
                contadorPaquetes.put(reserva.getPaqueteReservado(),
                        contadorPaquetes.get(reserva.getPaqueteReservado()) + 1);
        }
        return contadorPaquetes.getOrDefault(paquete,0) == 2;
    }
}
