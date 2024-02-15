package com.meli.deportistas.controller;

import com.meli.deportistas.dto.response.DeportistasDTO;
import com.meli.deportistas.model.Deporte;
import com.meli.deportistas.service.DeportistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DeportistasController {

    DeportistasService deportistasService;

    @Autowired
    public DeportistasController(DeportistasService deportistasService) {
        this.deportistasService = deportistasService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports(){
        return ResponseEntity.ok().body(deportistasService.findSports());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findSport(@PathVariable String name){
        Optional<Deporte> deporte = deportistasService.findSportByName(name);
        if(deporte.isPresent()){
            return ResponseEntity.ok().body(deportistasService.findSportByName(name).get());
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistasDTO>> findSportsPersons(){
        return ResponseEntity.ok().body(deportistasService.findSportsPersons());
    }

}
