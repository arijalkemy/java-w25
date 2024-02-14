package com.example.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.classes.*;;

public class RepositorioCliente {
    private Map<Cliente, List<Localizador>> listaClientes;

    public RepositorioCliente() {
        this.listaClientes = new HashMap<>();
    }

    public Map<Cliente, List<Localizador>> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Map<Cliente, List<Localizador>> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void agregarCliente(Cliente cliente, Localizador localizador) {
        boolean clienteExiste = false;
        for (Map.Entry<Cliente, List<Localizador>> entry : this.listaClientes.entrySet()) {
            if (entry.getKey().getId() == cliente.getId()) {
                clienteExiste = true;
                List<Localizador> listaAux = entry.getValue();
                listaAux.add(localizador);
                this.listaClientes.put(cliente, listaAux);
                break;
            }
        }
        if (!clienteExiste) {
            List<Localizador> lista = new ArrayList<>(List.of(localizador));
            this.listaClientes.put(cliente, lista);
        }

    }

    public double calcularTotal() {
        int primerDescuento = 0;
        int segundoDescuento = 0;
        int tercerDescuento = 0;
        double total = 0;
        for (Map.Entry<Cliente, List<Localizador>> entry : this.listaClientes.entrySet()) {
            if (entry.getValue().size() >= 2) {
                primerDescuento = 5;
            }
            for (Localizador localizador : entry.getValue()) {
                if (localizador.getCantidadBoletos() > 0
                        && localizador.getCantidadReservas() > 0 & localizador.isComida()) {
                    segundoDescuento = 10;
                }
                if (localizador.getCantidadBoletos() > 2 || localizador.getCantidadReservas() > 2) {
                    tercerDescuento = 10;
                }
                total += localizador.getTotal();
            }
        }
        return total - (total * (primerDescuento + segundoDescuento + tercerDescuento) / 100);
    }

}
