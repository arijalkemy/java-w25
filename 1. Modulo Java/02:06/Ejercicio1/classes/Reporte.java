package com.example.classes;

import java.util.List;
import java.util.Map;

public class Reporte {
    private Map<Cliente, List<Localizador>> listaClientes;

    public Reporte(Map<Cliente, List<Localizador>> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public int cantidadLocalizadoresVendidos() {
        int total = 0;
        for (Map.Entry<Cliente, List<Localizador>> entry : this.listaClientes.entrySet()) {
            total += entry.getValue().size();
        }
        return total;
    }

    public int cantidadReservas() {
        int totalReservas = 0;
        for (Map.Entry<Cliente, List<Localizador>> entry : this.listaClientes.entrySet()) {
            for (Localizador localizador : entry.getValue()) {
                totalReservas += localizador.getCantidadReservas();
            }
        }
        return totalReservas;
    }

    public int totalVentas() {
        return this.listaClientes.size();
    }

    public double promedioVentas() {
        int totalReservas = 0;
        for (Map.Entry<Cliente, List<Localizador>> entry : this.listaClientes.entrySet()) {
            for (Localizador localizador : entry.getValue()) {
                totalReservas += localizador.getTotal();
            }
        }
        return totalReservas / this.listaClientes.size();
    }
}
