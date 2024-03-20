package com.prendas.service;

import com.prendas.dto.PrendaDto;
import com.prendas.dto.ResponseDto;
import com.prendas.entity.Prenda;
import com.prendas.exceptions.NotFoundException;
import com.prendas.repository.IPrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrendaServiceImpl implements IPrendaService {
    private final IPrendaRepository prendaRepository;
    private final ModelMapper mapper;

    public PrendaServiceImpl(IPrendaRepository prendaRepository){
        this.prendaRepository = prendaRepository;
        mapper = new ModelMapper();
    }

    @Override
    public ResponseDto save(PrendaDto prendaDto) {
        System.out.println(prendaDto);
        Prenda prenda = mapper.map(prendaDto, Prenda.class);
        System.out.println(prenda);
        prendaRepository.save(prenda);
        return new ResponseDto("Prenda creada correctamente.", HttpStatus.CREATED.value());
    }

    @Override
    public List<PrendaDto> getCloths() {
        List<Prenda> listaPrendas = prendaRepository.findAll();
        return fromEntityToDtoList(listaPrendas);
    }

    @Override
    public List<PrendaDto> getClothBySize(String size) {
        List<Prenda> listaPrendas = prendaRepository.findByTalle(size);
        return fromEntityToDtoList(listaPrendas);
    }

    @Override
    public PrendaDto getClotheByCode(Long code) {
        Prenda prenda = prendaRepository.findById(code)
                .orElseThrow( ()-> new NotFoundException("Prenda no encontrada"));
        return mapper.map(prenda, PrendaDto.class);
    }

    @Override
    public ResponseDto updateClothe(Long code, PrendaDto prendaDto) {
        Optional<Prenda> prendaOpt = prendaRepository.findById(code);
        if(prendaOpt.isEmpty()) throw new NotFoundException("La prenda solicitada no existe, pa.");

        Prenda prenda = prendaOpt.get();
        if(prendaDto.getNombre() != null) prenda.setNombre(prendaDto.getNombre());
        if(prendaDto.getTipo() != null) prenda.setTipo(prendaDto.getTipo());
        if(prendaDto.getMarca() != null) prenda.setMarca(prendaDto.getMarca());
        if(prendaDto.getColor() != null) prenda.setColor(prendaDto.getColor());
        if(prendaDto.getTalle() != null) prenda.setTalle(prendaDto.getTalle());
        if(prendaDto.getCantidad() != null) prenda.setCantidad(prendaDto.getCantidad());
        if(prendaDto.getPrecioVenta() != null) prenda.setPrecioVenta(prendaDto.getPrecioVenta());

        prendaRepository.save(prenda);
        return new ResponseDto("Prenda actualizada correctamente. ID: " + prenda.getCodigo(),
                HttpStatus.OK.value());
    }

    @Override
    public ResponseDto deleteClothe(Long code) {
        Prenda prenda = prendaRepository.findById(code)
                .orElseThrow( ()-> new NotFoundException("Prenda no encontrada"));
        prendaRepository.delete(prenda);
        return new ResponseDto("Prenda eliminada", HttpStatus.OK.value());
    }

    @Override
    public List<PrendaDto> getClotheByName(String name) {
        List<Prenda> listaPrendas = prendaRepository.findByNombre(name);
        return fromEntityToDtoList(listaPrendas);
    }

    private List<PrendaDto> fromEntityToDtoList (List<Prenda> prendas){
        return prendas.stream()
                .map(prenda -> mapper.map(prenda, PrendaDto.class))
                .collect(Collectors.toList());
    }
}
