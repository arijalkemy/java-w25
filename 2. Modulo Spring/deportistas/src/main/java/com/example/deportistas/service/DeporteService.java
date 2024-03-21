package com.example.deportistas.service;


import com.example.deportistas.dto.response.DeporteDTO;
import com.example.deportistas.dto.response.DeporteListDTO;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.repository.DeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeporteService {

    @Autowired
    DeporteRepository deporteRepository;
    public DeporteListDTO getDeportes() {
        List<Deporte> deportes = deporteRepository.getDeportes();
        return new DeporteListDTO(deportes);
    }

    public DeporteDTO findSportByName(String name) {
        List<Deporte> deportes = deporteRepository.getDeportes();
        Optional<Deporte> deporte = deportes.stream().filter(d -> d.getNombre().equals(name)).findFirst();
        if (deporte.isPresent()) {
           return new DeporteDTO(deporte.get().getNombre(), deporte.get().getNivel());
        } else {
      throw new RuntimeException("Deporte no encontrado");
          }
    }
}
