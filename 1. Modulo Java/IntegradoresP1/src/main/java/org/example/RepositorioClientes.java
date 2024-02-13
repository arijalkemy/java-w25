package org.example;

import java.util.ArrayList;
import java.util.List;

public class RepositorioClientes {

    private static RepositorioClientes instance;
    private List<Cliente> clientes;

    private RepositorioClientes(){
        clientes = new ArrayList<>();
    }

    public static RepositorioClientes getInstance() {
        if(instance == null) instance = new RepositorioClientes();
        return instance;
    }
    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public Cliente obtenerCliente(String documento,String nombre){
        return clientes.stream()
                .filter(cliente -> cliente.getDocumento().equals(documento))
                .findFirst()
                .orElseGet(() -> {
                Cliente nuevoCliente = new Cliente(nombre,documento);
                agregarCliente(nuevoCliente);
                return nuevoCliente;
                    });


    }


}
