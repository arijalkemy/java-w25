package com.bootcamp.ejercicio_deportistas.service;

import com.bootcamp.ejercicio_deportistas.dto.DeporteDto;
import com.bootcamp.ejercicio_deportistas.entity.Deporte;
import com.bootcamp.ejercicio_deportistas.repository.IRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImp implements IService{

    IRepository repository;

    public ServiceImp(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DeporteDto> getAllSports() {
        List<Deporte> listaDeportes = repository.getAllSports();
        return listaDeportes.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private DeporteDto convertToDto(Deporte deporte){
        return new DeporteDto(
                deporte.getNombre(),
                deporte.getNivel()
        );
    }
}
