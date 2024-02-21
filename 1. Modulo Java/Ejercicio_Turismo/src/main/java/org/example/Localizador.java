package org.example;

import java.util.List;
import java.util.stream.Stream;

public class Localizador {

    private Cliente cliente;
    private List<Reserva> listaDeReservas;
    private double descuento = 0;
    private double montoOriginal = 0;
    private double montoFinal = 0;

    public Localizador(Cliente cliente, List<Reserva> listaDeReservas) {
        this.cliente = cliente;
        this.listaDeReservas = listaDeReservas;
        this.setMontoOriginal();
        this.checkDescuentos();
        this.descuentoPaquete();
        this.descuentoDosHotelesDosViajes();
        this.setMontoFinal();
    }

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
    }

    private void checkDescuentos() {
        // recorre el repo de localizadores para ver si tiene que aplicar descuentos
        long historialDelCliente = RepositorioLocalizador.countByClient(this.cliente);

        if (historialDelCliente >= 2) {
            this.descuento += 5;
        }
    }

    private void descuentoPaquete(){

        long viajes = listaDeReservas.stream().filter(reserva -> reserva.getNombre().equals("BoletoDeViaje")).count();
        long hoteles = listaDeReservas.stream().filter(reserva -> reserva.getNombre().equals("Hotel")).count();
        long comidas = listaDeReservas.stream().filter(reserva -> reserva.getNombre().equals("Comida")).count();
        long transportes = listaDeReservas.stream().filter(reserva -> reserva.getNombre().equals("Transporte")).count();
        if (viajes > 0 && hoteles > 0 && comidas > 0 && transportes > 0) {
            this.descuento += 10;
        }
    }

    private void descuentoDosHotelesDosViajes() {
        long viajes = listaDeReservas.stream().filter(reserva -> reserva.getNombre().equals("BoletoDeViaje")).count();
        long hoteles = listaDeReservas.stream().filter(reserva -> reserva.getNombre().equals("Hotel")).count();

        if (viajes >= 2 && hoteles >= 2) {
            listaDeReservas.stream().filter(reserva -> reserva.getNombre().equals("BoletoDeViaje"))
                    .forEach(reserva -> reserva.aplicarDescuento(5));
            listaDeReservas.stream().filter(reserva -> reserva.getNombre().equals("Hotel"))
                    .forEach(reserva -> reserva.aplicarDescuento(5));
        }
    }

    private void setMontoFinal() {
        this.montoFinal = this.listaDeReservas.stream()
                .mapToDouble(reserva -> reserva.getImporte()).sum() * (1 - this.descuento / 100);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getListaDeReservas() {
        return listaDeReservas;
    }

    public void setListaDeReservas(List<Reserva> listaDeReservas) {
        this.listaDeReservas = listaDeReservas;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoOriginal() {
        for(Reserva r : listaDeReservas) {
            this.montoOriginal += r.getImporte();
        }
    }

    public double getMontoOriginal() {
        return montoOriginal;
    }
}
