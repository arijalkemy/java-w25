package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.PersonaDeporteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaDeporteController {

    //Consultar todos los deportes
    @GetMapping ("/findSports")
    public ResponseEntity<List<PersonaDeporteDTO>> getSports() {
        return ResponseEntity.ok().body(service.);
    }

    //Consultar existencia de deporte por su nombre
    @GetMapping ("/findSport/{name}")
    public ResponseEntity<String> getSportName(@PathVariable String name) {

    }

    //Consultar a las personas deportistas
    public ResponseEntity<List<PersonaDeporteDTO>> getSportPersons(){

    }
}
