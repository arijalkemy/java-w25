package org.bootcamp.Repository;

import org.bootcamp.model.Client;
import org.bootcamp.model.Locator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ClientRepository {
    private List<Client> clientList;

    public ClientRepository() {
        loadData();
    }

    public Client getById(int idClient){
        Optional<Client> clientOpt = clientList.stream().filter(c->c.getIdClient()==idClient).findFirst();
        return clientOpt.orElse(null);
    }
    public Client getClient(Client client){
        if(getById(client.getIdClient())==null)
            addClient(client);
        return client;
    }
    public void addClient(Client client){
        clientList.add(client);
        System.out.println("Se agrego el cliente con éxito");
    }

    public List<Client> getClientList() {
        return clientList;
    }
    private void loadData(){
        clientList = new ArrayList<>(Arrays.asList(new Client(1,"Ema")));
    }
}
