package com.implementacionbd.ejercicio.service;

import org.springframework.stereotype.Service;

import com.implementacionbd.ejercicio.dto.ClienteDTO;
import com.implementacionbd.ejercicio.dto.MessageDTO;
import com.implementacionbd.ejercicio.model.Cliente;
import com.implementacionbd.ejercicio.model.Prenda;
import com.implementacionbd.ejercicio.repository.IClienteRepository;
import com.implementacionbd.ejercicio.repository.IPrendaRepository;

@Service
public class ClienteService implements IClienteService {
    private final IPrendaRepository prendaRepository;
    private final IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository, IPrendaRepository prendaRepository) {
        this.clienteRepository = clienteRepository;
        this.prendaRepository = prendaRepository;
    }

    private Cliente clienteDTOToModel(ClienteDTO clienteDTO) {
        return new Cliente(clienteDTO.getNombre(), clienteDTO.getApellido());
    }

    @Override
    public MessageDTO postCliente(ClienteDTO clienteDTO) {
        clienteRepository.save(clienteDTOToModel(clienteDTO));
        return new MessageDTO("El cliente fue agregada correctamente");
    }

    @Override
    public MessageDTO postRelationPrendaCliente(Long prendaId, Long clienteId) {
        Prenda prenda = prendaRepository.findById(prendaId).orElse(null);
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        if (prenda != null && cliente != null) {
            prenda.getClientes().add(cliente);
            prendaRepository.save(prenda);
        }
        return new MessageDTO("Relacion creada correctamente");
    }
}
