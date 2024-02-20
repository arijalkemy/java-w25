package com.example.deporte.controller;

import com.example.deporte.dto.DeporteDTO;
import com.example.deporte.dto.PersonaxDeporteDTO;
import com.example.deporte.factory.DeporteFactory;
import com.example.deporte.factory.DeportistaFactory;
import com.example.deporte.factory.PersonaFactory;
import com.example.deporte.repository.DeporteRepository;
import com.example.deporte.repository.PersonaxDeporteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Deporte {

    @GetMapping("/createSports")
    public void createDeportes() {
        DeporteFactory.createDeportes();
        PersonaFactory.createPersonas();
        DeportistaFactory.createDeportistas();
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> getAllDeportes() {
        return ResponseEntity.ok(DeporteRepository.getDeportes().stream().map(deporte -> new DeporteDTO(deporte.getNombre(), deporte.getNivel()
        )).collect(Collectors.toList()));
    }

    @GetMapping("/findSport/{nombre}")
    public ResponseEntity<String> getDeporte(@PathVariable String nombre) {
        return ResponseEntity.ok(DeporteRepository.getDeporte(nombre));
    }

    @GetMapping("findSportsPeople")
    public ResponseEntity<List<PersonaxDeporteDTO>> getSportPeople() {
        return ResponseEntity.ok(PersonaxDeporteRepository.getPersonaxDeportes().stream().map(deportista -> new PersonaxDeporteDTO(deportista.getPersona().getNombre(), deportista.getPersona().getApellido(), deportista.getDeporte().getNombre())).collect(Collectors.toList()));
    }
}
