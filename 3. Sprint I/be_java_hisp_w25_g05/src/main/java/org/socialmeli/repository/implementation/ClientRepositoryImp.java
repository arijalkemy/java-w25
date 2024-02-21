package org.socialmeli.repository.implementation;

import lombok.Data;
import org.socialmeli.entity.Client;
import org.socialmeli.entity.User;
import org.socialmeli.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class ClientRepositoryImp implements IRepository<Client> {
    private List<Client> clients = new ArrayList<>();
    private VendorRepositoryImp vendorRepositoryImp;

    public ClientRepositoryImp(VendorRepositoryImp vendorRepositoryImp) {
        this.vendorRepositoryImp = vendorRepositoryImp;
        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        Client client4 = new Client();

        client1.setUserName("Martin Perez");
        client2.setUserName("María García");
        client3.setUserName("Luis Rodríguez");
        client4.setUserName("Pepe Giménez");

        this.save(client1);
        this.save(client2);
        this.save(client3);
        this.save(client4);
    }

    private Integer autoIncrementId() {
        User.userIdCounter ++;
        return User.userIdCounter;
    }

    public List<Client> findAll() {
        return clients;
    }

    public Integer save(Client client) {
        client.setUserId(autoIncrementId());
        clients.add(client);
        return client.getUserId();
    }

    public Client findOne(Integer id) {
        return clients.stream()
                .filter(client -> client.getUserId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteOne(Integer id) {
        clients.removeIf(c -> c.getUserId().equals(id));
    }
}