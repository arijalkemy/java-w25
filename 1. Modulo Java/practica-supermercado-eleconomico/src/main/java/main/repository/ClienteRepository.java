package main.repository;

import main.Model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClienteRepository {

    private List<Cliente> clienteList;

    public ClienteRepository() {
        this.clienteList = new ArrayList<>();
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public String toString() {
        return "ClienteRepository{" +
                "clienteList=" + clienteList +
                '}';
    }

    public void crearCliente(Cliente cliente){
        this.clienteList.add(cliente);
    }

    public void mostrarClientes(){
        clienteList.forEach(System.out::println);
    }

    public void eliminarCliente(int dni){
        this.clienteList = this.clienteList.stream()
                            .filter(cliente -> cliente.getDni() != dni)
                            .collect(Collectors.toList());
    }

    public void buscarCliente(int dni){
        try{
            Optional<Cliente> clienteEncontrado = this.clienteList.stream()
                                .filter(cliente -> cliente.getDni() == dni)
                                .findFirst();
            System.out.println(clienteEncontrado.get());
        }catch (Exception e){
            System.out.println("El cliente no fue encontrado");
        }
    }
}
