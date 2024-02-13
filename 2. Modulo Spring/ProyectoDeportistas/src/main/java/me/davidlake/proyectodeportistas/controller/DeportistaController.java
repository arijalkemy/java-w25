package me.davidlake.proyectodeportistas.controller;

import me.davidlake.proyectodeportistas.dto.DeporteDTO;
import me.davidlake.proyectodeportistas.dto.DeportistaDTO;
import me.davidlake.proyectodeportistas.exception.NotFoundException;
import me.davidlake.proyectodeportistas.model.Deporte;
import me.davidlake.proyectodeportistas.model.Persona;
import me.davidlake.proyectodeportistas.repository.DeporteRepository;
import me.davidlake.proyectodeportistas.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestController
public class DeportistaController {

    private final DeporteRepository deporteRepository;
    private final PersonaRepository personaRepository;

    @Autowired
    public DeportistaController(
            DeporteRepository deporteRepository,
            PersonaRepository personaRepository
    ) {
        this.deporteRepository = deporteRepository;
        this.personaRepository = personaRepository;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports(){
        List<Deporte> deportes = deporteRepository.getAll();
        List<DeporteDTO> deportesDto = deportes
                .stream()
                .map((deporte)-> new DeporteDTO(deporte.getNombre(), deporte.getNivel()))
                .toList();

        return new ResponseEntity<>(deportesDto, HttpStatus.OK);
        // return new ResponseEntity.ok(deportesDto);
    }

    @GetMapping("/findSports/{name}")
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<DeporteDTO> findSport(@PathVariable String name){
        Optional<Deporte> deporte = deporteRepository.getPorNombre(name);
        if(deporte.isEmpty())
            throw new NotFoundException();
        return new ResponseEntity<>(new DeporteDTO(deporte.get().getNombre(), deporte.get().getNivel()), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportPersons(){
        List<Persona> personas = personaRepository.get();

        List<DeportistaDTO> deportistasDtos = personas
                .stream()
                .map(persona -> new DeportistaDTO(
                        persona.getNombre(),
                        persona.getApellido(),
                        persona.getDeporte().getNombre()))
                .toList();


        return new ResponseEntity<>(deportistasDtos, HttpStatus.OK);
    }
}
