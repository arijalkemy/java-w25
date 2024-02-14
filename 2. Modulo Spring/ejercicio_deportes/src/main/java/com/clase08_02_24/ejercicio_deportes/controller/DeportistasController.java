package com.clase08_02_24.ejercicio_deportes.controller;

import com.clase08_02_24.ejercicio_deportes.dto.AtletaDTO;
import com.clase08_02_24.ejercicio_deportes.dto.DeportesDTO;
import com.clase08_02_24.ejercicio_deportes.entity.Deporte;
import com.clase08_02_24.ejercicio_deportes.entity.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DeportistasController {

    List<Deporte> deportes = List.of(
            new Deporte("futbol", 2, List.of(new Persona("Luciano", "Rodriguez", 21))),
            new Deporte("Hockey", 3, List.of(new Persona("Tomas", "Rodriguez", 18)))
    );

    @GetMapping("/findSports")
    public ResponseEntity<List<DeportesDTO>> getAllDeportes () {
        List<DeportesDTO> deportesDto = new ArrayList<>();
        deportes.forEach(deporte -> {
            deportesDto.add(new DeportesDTO(deporte.getNombre(), deporte.getNivel()));
        });
        return new ResponseEntity<>(deportesDto, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeportesDTO> findDeporte (@PathVariable String name) {
        Optional<Deporte> deporteBuscado = deportes.stream().filter(d -> d.getNombre().equalsIgnoreCase(name)).findFirst();
        if(deporteBuscado.isEmpty()) throw new RuntimeException("No se encontro el deporte");
        return new ResponseEntity<>(
                new DeportesDTO(deporteBuscado.get().getNombre(), deporteBuscado.get().getNivel()),
                HttpStatus.OK
        );
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<AtletaDTO>> getAllPersonas () {
        List<AtletaDTO> personas = new ArrayList<>();
        deportes.forEach(d -> {
            d.getPersonasInscriptas().forEach(p -> {
                personas.add(new AtletaDTO(p.getNombre(), p.getApellido(), d.getNombre()));
            });
        });
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }




}
