package integracion.p1.general.services;

import integracion.p1.general.Client;
import integracion.p1.general.inteface.ICRUD;

import java.util.ArrayList;
import java.util.List;

public class ImpClient  implements ICRUD<Client, Integer> {

    List<Client> clients =new ArrayList<>();
    @Override
    public Client create(Client client) {
        clients.add(client);
        return client;
    }

    @Override
    public Client getBy(Integer id) {
        return this.clients.stream().filter(x-> x.getDni() == id ).findFirst().orElse(null);
    }

    @Override
    public List<Client> getAll() {
        return this.clients;
    }

    @Override
    public Client updateBy(Integer id, Client element) {
        this.clients.stream().filter(x-> x.getDni() == id ).forEach(x -> x = element);
        return element;
    }

    @Override
    public void deleteBy(Integer id) {
        this.clients = this.clients.stream().filter(x-> x.getDni() != id ).toList();
    }

}
