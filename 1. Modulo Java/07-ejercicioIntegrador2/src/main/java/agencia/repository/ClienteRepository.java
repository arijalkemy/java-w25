package agencia.repository;

import agencia.cliente.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository implements Repository<Cliente> {

    static List<Cliente> clientes = new ArrayList<>();

    @Override
    public List<Cliente> getAll() {
        return clientes;
    }

    @Override
    public Optional<Cliente> getOne(int id) {
        return clientes.stream()
                .filter(cliente -> cliente.getIdCliente() == id)
                .findFirst();
    }

    @Override
    public Cliente insert(Cliente elementInsert) {
        Optional<Cliente> existe = this.getOne(elementInsert.getIdCliente());

        if (existe.isEmpty()){
            clientes.add(elementInsert);

            return elementInsert;
        }

        return null;
    }

    @Override
    public Cliente update(Cliente elementUpdate) {

        return null;
    }

    @Override
    public Cliente delete(int id) {
        return null;
    }
}
