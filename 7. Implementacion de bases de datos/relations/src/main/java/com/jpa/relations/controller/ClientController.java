package com.jpa.relations.controller;

import com.jpa.relations.entity.Client;
import com.jpa.relations.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("/client")
    public ResponseEntity<Client> addNewClient(@RequestBody Client requestClient){
        return new ResponseEntity<>(clientService.AddClient(requestClient), HttpStatus.CREATED);
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id){
        return new ResponseEntity<>(clientService.deleteClient(id),HttpStatus.NO_CONTENT);
    }
}
