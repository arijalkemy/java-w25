package supermercado_luisina.repository;

import supermercado_luisina.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CrudRepository<Cliente> {

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void save(Cliente c) {
        clientes.add(c);
    }

    @Override
    public void mostrar() {
        for (Cliente c : clientes) {
            System.out.println("-----Cliente-----");
            System.out.println(c.toString());
        }
    }

    @Override
    public Optional<Cliente> buscar(Long dniBuscar) {
        boolean clienteEncontrado = false;

        for (Cliente c : clientes) {
            if (c.getDni().equals(dniBuscar)) {
                System.out.println("Cliente encontrado.");
                //System.out.println(c.toString());
                return Optional.of(c);
            }
        }

        if (!clienteEncontrado) {
            System.out.println("No se encontró el cliente.");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long dniEliminar) {

        Optional<Cliente> clienteBuscar = this.buscar(dniEliminar);

        if (clienteBuscar.isEmpty()) {
            System.out.println("No se encontró el cliente a eliminar.");
        } else {
            clientes.remove(clienteBuscar.get());
            System.out.println("Cliente eliminado correctamente.");
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return clientes;
    }
}
