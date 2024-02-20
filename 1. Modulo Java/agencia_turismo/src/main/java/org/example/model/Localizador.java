package org.example.model;

import java.util.List;

public class Localizador {
    private int idLocalizador;
    private Cliente cliente;
    private double total;
    private List<Reserva> listaReserva;

    public Localizador(int idLocalizador, Cliente cliente, List<Reserva> listaReserva) {
        this.idLocalizador = idLocalizador;
        this.cliente = cliente;
        this.listaReserva = listaReserva;
        this.total = calcularTotal();
    }

    //1. hotel
    //2. comida
    //3. vuelo
    //4. transporte

    public double calcularTotal(){
        double totalReservas = 0;
        for (Reserva reserva: listaReserva){
            totalReservas += reserva.getCosto();
        }

        return totalReservas;
    }
    public void aplicarDescuento(){
        int cantTipoHotel=0, cantTipoComida =0, cantTipoVuelo=0, cantTipoTransporte=0;
        double costoTipoHotel =0, costoTipoVuelo=0, costoTipoComida=0, costoTipoTransporte=0;

        for (Reserva reserva: listaReserva){
            if(reserva.getIdReserva() == 1){
                cantTipoHotel++;
                costoTipoHotel+=reserva.getCosto();
            }

            if(reserva.getIdReserva() == 2){
                cantTipoComida++;
                costoTipoComida+= reserva.getCosto();
            }

            if(reserva.getIdReserva() == 3){
                cantTipoVuelo++;
                costoTipoVuelo += reserva.getCosto();
            }

            if(reserva.getIdReserva() == 4){
                cantTipoTransporte++;
                costoTipoTransporte+= reserva.getCosto();
            }
        }

        if(cantTipoHotel == 2 && cantTipoVuelo == 2){
            costoTipoHotel*=.95;
            costoTipoVuelo*=.95;
        }

        total = costoTipoHotel + costoTipoComida + costoTipoVuelo + costoTipoTransporte;

        if(cantTipoHotel>0 && cantTipoComida>0 && cantTipoVuelo > 0 && cantTipoTransporte>0){
            total *=.90;
        }

        if(RepositorioLocalizador.adquirioAlMenosDosLocalizadores(cliente)){
            total *= .95;
        }
    }

    public int getIdLocalizador() {
        return idLocalizador;
    }

    public void setIdLocalizador(int idLocalizador) {
        this.idLocalizador = idLocalizador;
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

    public List<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "idLocalizador=" + idLocalizador +
                ", cliente=" + cliente +
                ", total=" + total +
                ", listaReserva=" + listaReserva +
                '}';
    }
}
