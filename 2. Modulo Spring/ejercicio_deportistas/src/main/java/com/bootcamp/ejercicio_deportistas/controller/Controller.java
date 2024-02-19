package com.bootcamp.ejercicio_deportistas.controller;

import com.bootcamp.ejercicio_deportistas.dto.DeporteDto;
import com.bootcamp.ejercicio_deportistas.dto.DeportistaDto;
import com.bootcamp.ejercicio_deportistas.dto.NivelDeporteDto;
import com.bootcamp.ejercicio_deportistas.service.IService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    IService service;

    public Controller(IService service) {
        this.service = service;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDto>> getDeportes(){
        return ResponseEntity
                .ok()
                .body(service.getAllSports());
    }
    @GetMapping("/findSports/{name}")
    public ResponseEntity<NivelDeporteDto> getNivelDeporte(@PathVariable String name){
        return ResponseEntity
                .ok()
                .body(service.getSportByName(name));
    }
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDto>> getDeportistas(){
        return ResponseEntity
                .ok()
                .body(service.getSportsman());
    }
}
