package com.implementacionbd.ejercicio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.implementacionbd.ejercicio.dto.MessageDTO;
import com.implementacionbd.ejercicio.dto.PrendaDTO;
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
        Iterable<Prenda> prendasIterator = prendaRepository.findAll();
        List<Prenda> prendasList = StreamSupport.stream(prendasIterator.spliterator(), false)
                .collect(Collectors.toList());
        List<PrendaDTO> prendaDTOList = new ArrayList<>();
        for (Prenda e : prendasList) {
            prendaDTOList.add(this.prendaModelToDTO(e));
        }
        return prendaDTOList;
    }

    @Override
    public PrendaDTO findPrendaById(String id) {
        Prenda prenda = prendaRepository.findById(id).orElse(null);
        if (prenda != null) {
            return prendaModelToDTO(prenda);
        }
        return null;
    }

    @Override
    public MessageDTO deletePrenda(String id) {
        Prenda prenda = prendaRepository.findById(id).orElse(null);
        if (prenda != null) {
            prendaRepository.deleteById(prenda.getId());
            return new MessageDTO("La prenda fue borrada correctamente");
        }
        return null;
    }

    @Override
    public PrendaDTO putPrenda(String id, PrendaDTO prendaDTO) {
        System.out.println("_id" + id);
        Prenda prenda = prendaRepository.findById(id).orElse(null);
        if (prenda == null) {
            return null;
        }
        prenda.setColor(prendaDTO.getColor());
        prenda.setMarca(prendaDTO.getMarca());
        prenda.setNombre(prendaDTO.getNombre());
        prendaRepository.save(prenda);
        return prendaModelToDTO(prenda);
    }

    @Override
    public List<PrendaDTO> findPrendaBySize(String size) {
        List<PrendaDTO> prendaDTOs = this.findAllPrendas().stream()
                .filter(p -> p.getTalle().toLowerCase().contains(size.toLowerCase()))
                .collect(Collectors.toList());
        return prendaDTOs;
    }

    @Override
    public List<PrendaDTO> findPrendaTipo(String tipo) {
        List<PrendaDTO> prendaDTOs = this.findAllPrendas().stream()
                .filter(p -> p.getTipo().toLowerCase().contains(tipo.toLowerCase()))
                .collect(Collectors.toList());
        return prendaDTOs;
    }

}
