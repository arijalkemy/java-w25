package ejerciciosIntegradores.agenciaDeTurismo.modelo.repositorios;

import ejerciciosIntegradores.agenciaDeTurismo.modelo.Cliente;

import java.util.*;

public class RepositorioClientes {
    private static RepositorioClientes instance;
    // private Map<Cliente, List<Localizador>> clientes = new HashMap<>();
    private List<Cliente> clientes = new ArrayList<>();

    private RepositorioClientes () {

    }
    public static RepositorioClientes getInstance(){
        if(instance == null) instance = new RepositorioClientes();
        return instance;
    }

    public Cliente buscarCliente(Cliente cliente) {
        Optional<Cliente> clienteBuscado = this.clientes.stream().filter(c -> c.equals(cliente)).findFirst();
        if(clienteBuscado.isEmpty()) {
            this.agregarCliente(cliente);
            return cliente;
        };
        return clienteBuscado.get();
    }
    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
}
