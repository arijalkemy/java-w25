package com.springboot.ejerciciodeportista.controller;

import com.springboot.ejerciciodeportista.dto.DeporteCompletoDTO;
import com.springboot.ejerciciodeportista.dto.DeporteNivelDTO;
import com.springboot.ejerciciodeportista.dto.DeporteNombreDTO;
import com.springboot.ejerciciodeportista.dto.PersonaDTO;
import com.springboot.ejerciciodeportista.entity.Deporte;
import com.springboot.ejerciciodeportista.entity.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/sport")
public class SportsController {

    @GetMapping("/findSports")
    public List<DeporteCompletoDTO> findSports() {
        return getDeportes().stream().map(deporte -> new DeporteCompletoDTO(deporte.getNombre(), deporte.getNivel())).toList();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteNivelDTO> findSportByName(@PathVariable String name) {
        Deporte deporte = getDeportes().stream().filter(sport -> Objects.equals(sport.getNombre(), name)).findFirst().orElse(null);

        if (deporte == null) {
            throw new RuntimeException("El deporte no se encontró en la BD");
        }

        DeporteNivelDTO deporteDTO = new DeporteNivelDTO(deporte.getNivel());

        return new ResponseEntity<>(deporteDTO, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public List<PersonaDTO> findPersonas() {
        return getPersonas().stream().map(persona -> new PersonaDTO(
                persona.getNombre(), persona.getApellido(),
                new DeporteNombreDTO(persona.getDeporte().getNombre()))).toList();
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
