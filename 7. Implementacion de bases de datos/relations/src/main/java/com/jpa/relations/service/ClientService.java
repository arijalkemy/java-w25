package com.jpa.relations.service;

import com.jpa.relations.entity.Client;
import com.jpa.relations.repositorory.IClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    IClientRepository clientRepository;

    public ClientService(IClientRepository repository) {
        this.clientRepository = repository;
    }

    public Client AddClient(Client client){
        return clientRepository.save(client);
    }

    public Long deleteClient(Long id){
        clientRepository.deleteById(id);
        return id;
    }
}
