package com.spring.deporte.service;

import com.spring.deporte.entity.Deporte;
import com.spring.deporte.dto.DeporteDTO;
import com.spring.deporte.exception.NotFoundException;
import com.spring.deporte.dto.mapper.DeporteMapper;
import com.spring.deporte.repository.DeporteRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeporteService {

    @Autowired
    DeporteRepository deporteRepository;

    public DeporteDTO buscarPorNombre(String nombre){
        Optional<Deporte> deporte = deporteRepository.buscarPorNombre(nombre);
        DeporteDTO response;
        if(deporte.isPresent())
            response  =  DeporteMapper.getInstance(deporte.get()) ;
        else
            throw new NotFoundException("deporte no encontrado");

        return response;
    }

    public List<DeporteDTO> todosLosDeportes(){
        return DeporteMapper.getInstances(deporteRepository.todosLosDeportes());
    }

}
