package com.bootcamp.ejercicio_deportistas.service;

import com.bootcamp.ejercicio_deportistas.dto.DeporteDto;
import com.bootcamp.ejercicio_deportistas.dto.DeportistaDto;
import com.bootcamp.ejercicio_deportistas.dto.NivelDeporteDto;
import com.bootcamp.ejercicio_deportistas.entity.Deporte;
import com.bootcamp.ejercicio_deportistas.entity.Persona;
import com.bootcamp.ejercicio_deportistas.repository.IRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                .map(this::convertDeporteToDto)
                .collect(Collectors.toList());
    }

    private DeporteDto convertDeporteToDto(Deporte deporte){
        return new DeporteDto(
                deporte.getNombre(),
                deporte.getNivel()
        );
    }


    @Override
    public NivelDeporteDto getSportByName(String name) {
        Optional<Deporte> deporte = repository.getSportByName(name);
        if (deporte.isPresent())
            return new NivelDeporteDto(deporte.get().getNivel());
        else
            throw new RuntimeException("No se encontró el deporte");
    }

    @Override
    public List<DeportistaDto> getSportsman() {
        List<Persona> personas = repository.getPeople();
        return personas.stream()
                .map(this::convertPersonaToDto)
                .collect(Collectors.toList());
    }
    private DeportistaDto convertPersonaToDto(Persona persona){
        return new DeportistaDto(
                persona.getNombre(),
                persona.getApellido(),
                persona.getDeporte().getNombre()
        );
    }
}
