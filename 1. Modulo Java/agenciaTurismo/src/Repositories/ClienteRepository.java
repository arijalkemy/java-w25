package Repositories;

import Interfaces.ICRUD;
import Models.Cliente;

import java.util.ArrayList;
import java.util.List;

class ClienteRepository implements ICRUD<Cliente> {
    public static List<Cliente> clienteList = new ArrayList<>();

    @Override
    public void create(Cliente cliente) {
        if (clienteList.stream().noneMatch(c -> c.getNombre().equals(cliente.getNombre())
                        && c.getApellido().equals(cliente.getApellido()))) {
            int id = !clienteList.isEmpty() ? clienteList.get(clienteList.size() -1).getId() + 1 : 1;
            cliente.setId(id);
            clienteList.add(cliente);
        }
    }

    @Override
    public List<Cliente> read() {
        return clienteList;
    }

    @Override
    public void update(Cliente cliente) {
        Cliente clienteencontrado = findById(cliente.getId());
        if (clienteencontrado != null) {
            clienteList.remove(clienteencontrado);
            clienteList.add(cliente);
        } else {
            System.out.println("Cliente no existe");
        }
    }


    @Override
    public Cliente findById(int clienteId) {
        return clienteList.stream().filter(c -> c.getId() == clienteId).findFirst().orElse(null);



    }

    @Override
    public void delete(Cliente cliente) {
        Cliente clienteencontrado = findById(cliente.getId());
        if (clienteencontrado != null) {
            clienteList.remove(clienteencontrado);
        } else {
            System.out.println("Cliente no existe");
        }

    }

}

