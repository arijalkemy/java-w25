package org.mercadolibre.deportistas.controller;

import org.mercadolibre.deportistas.dto.DeporteDTO;
import org.mercadolibre.deportistas.dto.DeportistaDTO;
import org.mercadolibre.deportistas.model.Deporte;
import org.mercadolibre.deportistas.model.Persona;
import org.mercadolibre.deportistas.repository.DeportesRepository;
import org.mercadolibre.deportistas.repository.PersonasRepository;
import org.mercadolibre.deportistas.exception.NotFoundException;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;
import java.util.Optional;



@RestController
public class DeportistasController {
    private final DeportesRepository deportesRepository;
    private final PersonasRepository personasRepository;

    @Autowired
    public DeportistasController(DeportesRepository deportesRepository, PersonasRepository personasRepository) {
        this.deportesRepository = deportesRepository;
        this.personasRepository = personasRepository;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports(){
        List<Deporte> deportes = deportesRepository.getAll();
        List<DeporteDTO> deportesDto = deportes
                .stream()
                .map((deporte)-> new DeporteDTO(deporte.getNombre(), deporte.getNivel()))
                .toList();

        return new ResponseEntity<>(deportesDto, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<DeporteDTO> findSport(@PathVariable String name){
        Optional<Deporte> deporte = deportesRepository.getSportByName(name);
        if(deporte.isEmpty())
            throw new NotFoundException();
        return new ResponseEntity<>(new DeporteDTO(deporte.get().getNombre(), deporte.get().getNivel()), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportPersons(){
        List<Persona> personas = personasRepository.getAll();

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
