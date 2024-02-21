package Supermercado.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import Supermercado.Interfaces.ICRUD;
import Supermercado.Models.Cliente;

public class ClienteController implements ICRUD<Cliente>{
    
    final List<Cliente> clientes = new ArrayList<>();

    @Override
    public void create(Cliente cliente){
        clientes.add(new Cliente(cliente.getDocumento(), cliente.getNombre()));
        System.out.println("Cliente creado: \n" + cliente.toString());
    }

    @Override
    public void read() {
        clientes.stream().forEach(System.out::println);
    }

    @Override
    public void update(Cliente cliente) {
        Optional<Cliente> clienteActualizar = clientes.stream()
                                                    .filter(clienteBuscado -> clienteBuscado.getId() == cliente.getId())
                                                    .findFirst();
        if (clienteActualizar.isPresent()){
            Cliente clienteActualizado = clienteActualizar.get();
            clienteActualizado.setNombre(cliente.getNombre());
            clienteActualizado.setDocumento(cliente.getDocumento());
            clientes.set(clientes.indexOf(clienteActualizado), clienteActualizado);
            System.out.println("Cliente actualizado: \n" + clienteActualizado.toString());
        } else {
            System.out.println("No se encontro al cliente");
        }
    }

    @Override
    public void delete(Cliente cliente) {
        Optional<Cliente> clienteActualizar = clientes.stream()
                                                    .filter(clienteBuscado -> clienteBuscado.getDocumento() == cliente.getDocumento())
                                                    .findFirst();
        if (clienteActualizar.isPresent()){
            Cliente clienteActualizado = clienteActualizar.get();
            System.out.println("Cliente creado: \n" + clienteActualizado.toString());
        } else {
            System.out.println("No se encontro al cliente");
        }
    }

    
}
