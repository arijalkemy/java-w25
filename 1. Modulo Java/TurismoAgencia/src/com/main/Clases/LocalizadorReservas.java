package com.main.Clases;

import com.main.Servicios.Reservas;

import java.util.List;

public class LocalizadorReservas {
    public Cliente cliente;
    public double total;
    List <Reservas> serviciosList;

    public LocalizadorReservas(Cliente cliente, double total, List<Reservas> serviciosList) {
        this.cliente = cliente;
        this.total = total;
        this.serviciosList = serviciosList;
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

    public List<Reservas> getServiciosList() {
        return serviciosList;
    }

    public void setServiciosList(List<Reservas> serviciosList) {
        this.serviciosList = serviciosList;
    }

    @Override
    public String toString() {
        return "\n" +cliente + "\nServicios: " + serviciosList +"\nTotal: " + total;
    }
}
