package bootcamp.Repositorios;

import bootcamp.Models.Cliente;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {
    private List<Cliente> clientes;

    public RepositorioCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public RepositorioCliente() {
        clientes = new ArrayList<>();
    }

    public void add(Cliente c){
        clientes.add(c);
    }
}
