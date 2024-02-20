package org.example.model;

import java.util.List;
import java.util.Optional;

public class RepositorioCliente {
    public List<Cliente> clientes;

    public Optional<Cliente> buscarReservas(Cliente cliente){

        Optional<Cliente> clienteBuscado =  clientes.stream()
                                            .filter(x->x.getIdCliente() == cliente.getIdCliente())
                                            .findFirst();

        if(clienteBuscado.isEmpty())
        {
            agregarCliente(cliente);
            return Optional.ofNullable(cliente);
        }else{
            return clienteBuscado;
        }
    }
    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }
}
