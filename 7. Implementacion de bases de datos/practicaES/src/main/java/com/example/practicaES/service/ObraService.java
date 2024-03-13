package com.example.practicaES.service;

import com.example.practicaES.controller.ObraController;
import com.example.practicaES.dto.MessageDto;
import com.example.practicaES.dto.ObraDto;
import com.example.practicaES.entities.Obra;
import com.example.practicaES.repository.IObraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObraService implements IObraService{
    IObraRepository obraRepository;
    ModelMapper mapper;

    public ObraService(IObraRepository obraRepository, ModelMapper mapper){
        this.obraRepository = obraRepository;
        this.mapper = mapper;
    }


    @Override
    public MessageDto addObra(ObraDto obraDto) {
        Obra obra = mapper.map(obraDto, Obra.class );
        obraRepository.save(obra);
        return new MessageDto("Se agrego joya: ", mapper.map(obra, ObraDto.class));
    }

    @Override
    public List<ObraDto> findAll() {
        List<Obra> obras = obraRepository.findAll();
        return obras
                .stream()
                .map(obra -> mapper.map(obra, ObraDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> findByAutor(String autor) {
        List<Obra> obras = obraRepository.findByAutor(autor);
        return obras
                .stream()
                .map(obra -> mapper.map(obra, ObraDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> findByNombre(String nombre) {
        List<Obra> obras = obraRepository.findByNombreLike(nombre);
        return obras
                .stream()
                .map(obra -> mapper.map(obra, ObraDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> getTop5Pages() {
        List<Obra> obras = obraRepository.findTop5ByOrderByPaginasDesc();
        return obras
                .stream()
                .map(obra -> mapper.map(obra, ObraDto.class))
                .collect(Collectors.toList());
    }
}

