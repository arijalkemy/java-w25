package com.example.deportes.controller;

import com.example.deportes.Deporte;
import com.example.deportes.Persona;
import com.example.deportes.dtos.DeporteDto;
import com.example.deportes.dtos.PersonaDto;
import com.example.deportes.repository.DeportesRepository;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class DeportesController {

    @GetMapping("findSports")
    public ResponseEntity<List<Deporte>> getAll(){

        return new ResponseEntity<>(DeportesRepository.deportes, HttpStatus.OK) ;
    }

    @GetMapping("findSports/{name}")
    public ResponseEntity<DeporteDto>  getByName(@PathVariable String name){
        Optional<Deporte> deporte =  DeportesRepository.deportes.stream().filter(d -> d.getNombre().equals(name)).findFirst();
        return deporte.isPresent() ? new ResponseEntity<>( new DeporteDto(deporte.get().getNivel()), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<PersonaDto>> getPersonas(){
        List<PersonaDto> personas = DeportesRepository.personas.stream().map( p -> new PersonaDto(p.getNombre(), p.getApellido(), p.getDeportes().stream().map(d -> d.getNombre()).toList())).toList();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }
}
