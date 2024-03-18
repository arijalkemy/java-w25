package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.DeporteDTO;
import com.bootcamp.deportistas.dto.PersonaDeporteDTO;
import com.bootcamp.deportistas.service.PersonaDeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaDeporteController {
    PersonaDeporteService personaDeporteService;

    public PersonaDeporteController(PersonaDeporteService personaDeporteService) {
        this.personaDeporteService = personaDeporteService;
    }

    //Consultar todos los deportes
    @GetMapping ("/findSports")
    public ResponseEntity<List<DeporteDTO>> getSports() {
        return ResponseEntity.ok().body(personaDeporteService.findSports());
    }

    //Consultar existencia de deporte por su nombre
    @GetMapping ("/findSport/{name}")
    public ResponseEntity<String> getSportName(@PathVariable String name) {
        DeporteDTO deporteDTO = personaDeporteService.findSportsName(name);

        if(deporteDTO != null) {
            return new ResponseEntity<String>(deporteDTO.getNivel(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("no existe deporte", HttpStatus.NOT_FOUND);
        }
    }

    //Consultar a las personas deportistas
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeporteDTO>> getSportPersons(){
        List<PersonaDeporteDTO> personaDeportista = personaDeporteService.findSportsPersons();
        return new ResponseEntity<>(personaDeportista, HttpStatus.OK);
    }
}
