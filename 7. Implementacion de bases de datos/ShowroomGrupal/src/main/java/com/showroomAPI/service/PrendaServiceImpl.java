package com.showroomAPI.service;

import com.showroomAPI.dto.request.PrendaDto;
import com.showroomAPI.dto.response.MessageDto;
import com.showroomAPI.exception.NotFoundException;
import com.showroomAPI.model.Prenda;
import com.showroomAPI.repository.IPrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrendaServiceImpl implements IPrendaService{

    private final IPrendaRepository prendaRepository;
    private final ModelMapper modelMapper;

    public PrendaServiceImpl(IPrendaRepository prendaRepository, ModelMapper modelMapper) {
        this.prendaRepository = prendaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MessageDto createPrenda(PrendaDto prendaDto) {
        this.prendaRepository.save(modelMapper.map(prendaDto, Prenda.class));
        return new MessageDto("Prenda creada con exito");
    }

    @Override
    public List<PrendaDto> getPrendas() {
        return this.prendaRepository.findAll().stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PrendaDto getPrendaByCode(Long code) {
        return modelMapper.map(this.prendaRepository.findById(code)
                .orElseThrow(() -> new NotFoundException("No se encontro el caso de prueba")), PrendaDto.class);
    }

    @Override
    public MessageDto updatePrendaByCode(Long code, PrendaDto prendaDto) {

        Prenda prendaActual = modelMapper.map(this.getPrendaByCode(code), Prenda.class);
        Prenda prendaUpdate = modelMapper.map(prendaDto, Prenda.class);

        prendaUpdate.setCodigo(code);
        prendaUpdate.setNombre(prendaUpdate.getNombre() != null ? prendaUpdate.getNombre() : prendaActual.getNombre());
        prendaUpdate.setTipo(prendaUpdate.getTipo() != null ? prendaUpdate.getTipo() : prendaActual.getTipo());
        prendaUpdate.setMarca(prendaUpdate.getMarca() != null ? prendaUpdate.getMarca() : prendaActual.getMarca());
        prendaUpdate.setColor(prendaUpdate.getColor() != null ? prendaUpdate.getColor() : prendaActual.getColor());
        prendaUpdate.setTalla(prendaUpdate.getTalla() != null ? prendaUpdate.getTalla() : prendaActual.getTalla());
        prendaUpdate.setCantidad(prendaUpdate.getCantidad() != null ? prendaUpdate.getCantidad() : prendaActual.getCantidad());
        prendaUpdate.setPrecio(prendaUpdate.getPrecio() != null ? prendaUpdate.getPrecio() : prendaActual.getPrecio());

        this.prendaRepository.save(prendaUpdate);

        return new MessageDto("Prenda actualizada con exito");
    }


}
