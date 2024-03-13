package com.implementacionbd.ejercicio.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.implementacionbd.ejercicio.dto.ClienteDTO;
import com.implementacionbd.ejercicio.dto.MessageDTO;
import com.implementacionbd.ejercicio.service.ClienteService;

@RestController
@RequestMapping("/client")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/")
    public ResponseEntity<MessageDTO> postCliente(@RequestBody ClienteDTO clienteDTO) {
        MessageDTO messageDTO = clienteService.postCliente(clienteDTO);
        return new ResponseEntity<>(messageDTO, HttpStatusCode.valueOf(201));
    }

    @PostMapping("/relation/{prendaId}/{clienteId}")
    public ResponseEntity<MessageDTO> postRelationPrendaCliente(@PathVariable Long prendaId,
            @PathVariable Long clienteId) {
        MessageDTO messageDTO = clienteService.postRelationPrendaCliente(prendaId, clienteId);
        return new ResponseEntity<>(messageDTO, HttpStatusCode.valueOf(201));
    }
}
