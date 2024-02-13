package org.deportistas.controller;

import org.deportistas.dto.SportsDTO;
import org.deportistas.dto.SportsPeopleDTO;
import org.deportistas.model.Deporte;
import org.deportistas.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class Controller {
    @GetMapping("/findSports")
    public ResponseEntity<SportsDTO> getSports() {
        List<Deporte> deportes = List.of(
                new Deporte("Natación", "Intermedio"),
                new Deporte("Fútbol", "Principiante"));

        return new ResponseEntity<>(new SportsDTO(deportes), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name) {
        List<Deporte> deportes = List.of(
                new Deporte("natacion", "intermedio"),
                new Deporte("futbol", "principiante"));

        Optional<Deporte> deporte = deportes.stream()
                .filter(d -> Objects.equals(d.getNombre(), name))
                .findFirst();

        if (deporte.isPresent())
            return new ResponseEntity<>(deporte.get().getNivel(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Deporte no encontrado", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportsPeopleDTO>> getSportsPeople() {
        List<Deporte> deportes = List.of(
                new Deporte("natacion", "intermedio"),
                new Deporte("futbol", "principiante"));

        List<Persona> personas = List.of(
                new Persona("Juan", "Perez", 23, deportes.get(0)),
                new Persona("Rodrigo", "Gutierrez", 31, deportes.get(0)),
                new Persona("Pedro", "Dominguez", 31, deportes.get(1)));

        List<SportsPeopleDTO> resDTO = personas.stream()
                .map(p -> new SportsPeopleDTO(p.getNombre(), p.getApellido(), p.getDeporte().getNombre()))
                .toList();

        return new ResponseEntity<>(resDTO, HttpStatus.OK);
    }
}
