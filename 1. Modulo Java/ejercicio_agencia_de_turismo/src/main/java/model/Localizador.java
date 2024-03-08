package model;

import java.util.HashMap;
import java.util.List;

public class Localizador {
    private List<Reserva> reservas;
    private Cliente cliente;
    private double precioTotal;

    public Localizador( Cliente cliente, List<Reserva> reservas) {
        this.reservas = reservas;
        this.cliente = cliente;
        calcularPrecioTotal();
    }

    public double getPrecioTotal() {
        return precioTotal;
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
        if(descuentoPaqueteCompleto())  precioTotal *= 0.90;

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
                    .mapToDouble(reserva -> reserva.getPrecio() * 0.05)
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
