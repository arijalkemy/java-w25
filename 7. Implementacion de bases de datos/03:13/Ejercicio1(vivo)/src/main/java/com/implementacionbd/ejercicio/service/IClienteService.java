package com.implementacionbd.ejercicio.service;

import com.implementacionbd.ejercicio.dto.ClienteDTO;
import com.implementacionbd.ejercicio.dto.MessageDTO;

public interface IClienteService {
    public MessageDTO postCliente(ClienteDTO clienteDTO);

    public MessageDTO postRelationPrendaCliente(Long prendaId, Long clienteId);
}
