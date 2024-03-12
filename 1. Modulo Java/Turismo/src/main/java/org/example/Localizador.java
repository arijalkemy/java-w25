package org.example;

import java.util.List;

public class Localizador {

    private Cliente cliente;
    private double total;
    private List<Reserva> listaDeReservas;
    private int descuento = 0;
    private double monto;

    public Localizador(Cliente cliente, List<Reserva> listaDeReservas) {
        this.cliente = cliente;
        this.listaDeReservas = listaDeReservas;
        this.checkDescuentos();
        this.setMonto();
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

    private int cantidadDeReservasTipo(){

        listaDeReservas.stream().filter(reserva -> reserva.getNombre().equals("")).count();
        listaDeReservas.stream().filter(reserva -> reserva instanceof ReservaComida).count();
        listaDeReservas.stream().filter(reserva -> reserva instanceof ReservaTransporte).count();
        listaDeReservas.stream().filter(reserva -> reserva instanceof ReservaBoletoDeViaje).count();
        return 1;
    }


    private void checkPaqueteCompleto() {

        long count = listaDeReservas.stream()
                .map(Reserva::getNombre)
                .distinct()
                .count();

    }

    private void setMonto() {
        this.monto = this.listaDeReservas.stream()
                .mapToDouble(reserva -> reserva.getImporte()).sum() * (1 - this.descuento / 100);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Reserva> getListaDeReservas() {
        return listaDeReservas;
    }

    public void setListaDeReservas(List<Reserva> listaDeReservas) {
        this.listaDeReservas = listaDeReservas;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
