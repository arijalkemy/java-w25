package com.implementacionbd.ejercicio.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.implementacionbd.ejercicio.dto.MessageDTO;
import com.implementacionbd.ejercicio.dto.PrendaDTO;
import com.implementacionbd.ejercicio.model.Cliente;
import com.implementacionbd.ejercicio.model.Prenda;
import com.implementacionbd.ejercicio.repository.IPrendaRepository;

@Service
public class PrendaService implements IPrendaService {
    private final IPrendaRepository prendaRepository;

    public PrendaService(IPrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }

    private Prenda prendaDTOToModel(PrendaDTO prendaDTO) {
        return new Prenda(prendaDTO.getNombre(), prendaDTO.getTipo(), prendaDTO.getMarca(), prendaDTO.getColor(),
                prendaDTO.getTalle(), prendaDTO.getCantidad(), prendaDTO.getPrecioVenta());
    }

    private PrendaDTO prendaModelToDTO(Prenda prenda) {
        return new PrendaDTO(prenda.getNombre(), prenda.getTipo(), prenda.getMarca(), prenda.getColor(),
                prenda.getTalle(), prenda.getCantidad(), prenda.getPrecioVenta());
    }

    @Override
    public MessageDTO postPrenda(PrendaDTO prendaDTO) {
        prendaRepository.save(this.prendaDTOToModel(prendaDTO));
        return new MessageDTO("La prenda fue agregada correctamente");
    }

    @Override
    public List<PrendaDTO> findAllPrendas() {
        List<Prenda> prendas = prendaRepository.findAll();
        List<PrendaDTO> prendaDTOs = new ArrayList<>();
        for (Prenda e : prendas) {
            prendaDTOs.add(this.prendaModelToDTO(e));
        }
        return prendaDTOs;
    }

    @Override
    public PrendaDTO findPrendaById(Long id) {
        Prenda prenda = prendaRepository.findById(id).orElse(null);
        if (prenda != null) {
            return prendaModelToDTO(prenda);
        }
        return null;
    }

    @Override
    public MessageDTO deletePrenda(Long id) {
        Prenda prenda = prendaRepository.findById(id).orElse(null);
        if (prenda != null) {
            Set<Cliente> clientes = new HashSet<>();
            prenda.setClientes(clientes);
            prendaRepository.save(prenda);
            prendaRepository.deleteById(prenda.getId());
            return new MessageDTO("La prenda fue borrada correctamente");
        }
        return null;
    }

    @Override
    public PrendaDTO putPrenda(Long id, PrendaDTO prendaDTO) {
        Prenda prenda = prendaRepository.findById(id).orElse(null);
        prenda.setColor(prendaDTO.getColor());
        prenda.setMarca(prendaDTO.getMarca());
        prenda.setNombre(prendaDTO.getNombre());
        prendaRepository.save(prenda);
        return prendaModelToDTO(prenda);
    }

    @Override
    public List<PrendaDTO> findPrendaBySize(String size) {
        List<Prenda> prendas = prendaRepository.findPrendaBySize(size);
        List<PrendaDTO> prendaDTOs = new ArrayList<>();
        for (Prenda e : prendas) {
            prendaDTOs.add(this.prendaModelToDTO(e));
        }
        return prendaDTOs;
    }

    @Override
    public List<PrendaDTO> findPrendaTipo(String tipo) {
        List<Prenda> prendas = prendaRepository.findPrendaTipo(tipo);
        List<PrendaDTO> prendaDTOs = new ArrayList<>();
        for (Prenda e : prendas) {
            prendaDTOs.add(this.prendaModelToDTO(e));
        }
        return prendaDTOs;
    }

}
