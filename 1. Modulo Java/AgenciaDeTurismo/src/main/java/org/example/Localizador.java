package org.example;

import java.util.ArrayList;
import java.util.List;

public class Localizador {

    private List<Reserva> reservas;
    private Cliente cliente;
    public Localizador(Cliente Cliente,List<Reserva> reservas){
        this.cliente = Cliente;
        this.reservas = reservas;
    }

    public boolean esPaqueteCompleto () {
        // Filtro por cada tipo de reserva
        List<Reserva> reservasDeHotel = reservas.stream().filter(r -> r.getTipoReserva().equals(TipoReserva.HOTEL)).toList();
        List<Reserva> reservasDeComida = reservas.stream().filter(r -> r.getTipoReserva().equals(TipoReserva.COMIDA)).toList();
        List<Reserva> reservasDeTransporte = reservas.stream().filter(r -> r.getTipoReserva().equals(TipoReserva.TRANSPORTE)).toList();
        List<Reserva> reservasDeBoleto = reservas.stream().filter(r -> r.getTipoReserva().equals(TipoReserva.BOLETO)).toList();
        // Devuelvo un booleano. Cada condicion esta conectada por un operador logico, tienen que ser todas true para que den true
        boolean condicion = (!reservasDeHotel.isEmpty() && !reservasDeComida.isEmpty()
                            && !reservasDeTransporte.isEmpty() && !reservasDeBoleto.isEmpty());
        System.out.println("Es paquete completo: " + condicion);
        return condicion;
    }
    public double getTotal(){
        return reservas.stream().mapToDouble(Reserva::getTotal).sum();
    }

    public List<Reserva> getReservas() { return reservas; }

    public Cliente getCliente() { return cliente; }
    public void  agregarReserva(Reserva reserva){ this.reservas.add(reserva); }





}

