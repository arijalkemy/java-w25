package main.java.com.bootcamp.repository;

import main.java.com.bootcamp.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class RepositoryCliente {
    private List<Cliente> clientes;

    public RepositoryCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public RepositoryCliente() {
        clientes = new ArrayList<>();
    }

    public void add(Cliente c){
        clientes.add(c);
    }
}
