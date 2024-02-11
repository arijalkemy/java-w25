package bootcamp.Repositories;

import bootcamp.Model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepositoryImp implements ICRUD<Cliente> {
    private List<Cliente> clientes;

    public ClienteRepositoryImp() {
        this.clientes = new ArrayList<>();
    }

    public ClienteRepositoryImp(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public void save(Cliente saved) {
        clientes.add(saved);
    }

    @Override
    public List<Cliente> getAll() {
        return clientes;
    }

    @Override
    public void remove(Cliente removed) {
        this.clientes.remove(removed);
    }
    public Optional<Cliente> getByDNI(String dni){
        return this.clientes.stream().filter(cliente -> cliente.getDni().equals(dni)).findFirst();

    }
    public void MostrarClientes(){
        this.clientes.forEach(System.out::println);
    }
    public void removeByDni(String dni){
        Optional<Cliente> cliente = this.getByDNI(dni);
        cliente.ifPresent(value -> this.clientes.remove(value));

    }
}
