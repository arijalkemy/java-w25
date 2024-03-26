package com.mercadolibre.new_app_01.controller;

import com.mercadolibre.new_app_01.dtos.DificultadDeporteDTO;
import com.mercadolibre.new_app_01.dtos.NombreDeporteDTO;
import com.mercadolibre.new_app_01.dtos.PersonaDTO;
import com.mercadolibre.new_app_01.entity.Deporte;
import com.mercadolibre.new_app_01.entity.Persona;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

// rest controller
@RestController
public class DeportistaController {
    @GetMapping("/findSports")
    private List<NombreDeporteDTO> findSport(){
        return getDeportes().stream().map(sport -> new NombreDeporteDTO(sport.getNombre())).collect(Collectors.toList());
    }

    @GetMapping("/findSport/{name}")
    private ResponseEntity<DificultadDeporteDTO> findSportByName(@PathVariable String name){
        try {
            return ResponseEntity.ok(new DificultadDeporteDTO(getDeportes().stream().filter(sport -> sport.getNombre().equals(name)).findFirst().get().getNivel()));
        } catch (Exception e) {
            // return 404
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findSportsPersons")
    private ResponseEntity<List<PersonaDTO>> findSportsPersons(){
        return ResponseEntity.ok(getPersonas().stream().map(person -> new PersonaDTO(person.getNombre(), person.getApellido(), new NombreDeporteDTO(person.getDeporte().getNombre()))).collect(Collectors.toList()));
    }

    private List<Deporte> getDeportes() {
        return List.of(
                new Deporte("CrossFit", "Advanced"),
                new Deporte("Rugby", "Amateur"),
                new Deporte("Soccer", "Middle")
        );
    }

    private List<Persona> getPersonas() {
        return List.of(
                new Persona("Nicolás", "Aimar", 28, new Deporte("CrossFit", "Advanced")),
                new Persona("John", "Doe", 30, new Deporte("Rugby", "Amateur")),
                new Persona("Juan", "Pérez", 20, new Deporte("Soccer", "Middle"))
        );
    }
}
