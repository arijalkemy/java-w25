package integracion.p1.agencia.repo;
import integracion.p1.agencia.base.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepo {
    private List<Client> clientList = new ArrayList<>();

    public Client findByDni(int dni){
        return clientList.stream().filter(x-> x.getDni() == dni).findFirst().orElse(null);
    }
    public void addClient(Client client){
        this.clientList.add(client);
    }

    public void deleteClientByDni(int dni){
        this.clientList = this.clientList.stream().filter(x -> x.getDni() != dni ).toList();
    }
}
