package com.showroom.exercise.service;

import com.showroom.exercise.dto.PrendaDTO;
import com.showroom.exercise.dto.ResponseDTO;
import com.showroom.exercise.exceptions.NotFoundException;
import com.showroom.exercise.model.Prenda;
import com.showroom.exercise.repository.IPrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaService implements IPrendaService{
    private final IPrendaRepository prendaRepository;
    private final ModelMapper mapper;

    public PrendaService(IPrendaRepository prendaRepository, ModelMapper mapper) {
        this.prendaRepository = prendaRepository;
        this.mapper = mapper;
    }

    @Override
    public PrendaDTO savePrenda(PrendaDTO prendaDTO) {
        prendaRepository.save(mapper.map(prendaDTO, Prenda.class));
        return prendaDTO;
    }

    @Override
    public List<PrendaDTO> getPrendas() {
        return prendaRepository.findAll().stream().map(prenda -> mapper.map(prenda, PrendaDTO.class)).toList();
    }

    @Override
    public PrendaDTO getPrendaById(Long id) {
        Prenda prenda= prendaRepository.findById(id).orElseThrow(()-> new NotFoundException("Prenda con id no encontrado"));

        return mapper.map(prenda, PrendaDTO.class);
    }

    @Override
    public PrendaDTO updatePrenda(Long id, PrendaDTO prendaDTO) {
        Prenda prenda= prendaRepository.findById(id).orElseThrow(()-> new NotFoundException("Prenda con id no encontrado"));

        if (prendaDTO.getCantidad() != null) prenda.setCantidad(prendaDTO.getCantidad());
        if (prendaDTO.getMarca() != null) prenda.setMarca(prendaDTO.getMarca());
        if (prendaDTO.getColor() != null) prenda.setColor(prendaDTO.getColor());
        if (prendaDTO.getTalla() != null) prenda.setTalla(prendaDTO.getTalla());
        if (prendaDTO.getNombre() != null) prenda.setNombre(prendaDTO.getNombre());
        if (prendaDTO.getTipo() != null) prenda.setTipo(prendaDTO.getTipo());
        if (prendaDTO.getPrecioVenta() != null) prenda.setPrecioVenta(prendaDTO.getPrecioVenta());

        Prenda newPrenda=prendaRepository.save(prenda);

        return mapper.map(newPrenda, PrendaDTO.class);
    }

    @Override
    public ResponseDTO deletePrenda(Long id) {
        prendaRepository.findById(id).orElseThrow(()-> new NotFoundException("Prenda con id no encontrado"));

        prendaRepository.deleteById(id);

        return new ResponseDTO("Prenda eliminada correctamente");
    }

    @Override
    public List<PrendaDTO> getPrendasByTalla(String talla) {
        return prendaRepository.findAllByTalla(talla).stream().map(prenda -> mapper.map(prenda, PrendaDTO.class)).toList();
    }

    @Override
    public List<PrendaDTO> getPrendasContainsNombre(String nombre) {
        return prendaRepository.findAllByNombreContainingIgnoreCase(nombre).stream().map(prenda -> mapper.map(prenda, PrendaDTO.class)).toList();
    }
}
