package com.bootcamp.ejercicio_deportistas.controller;

import com.bootcamp.ejercicio_deportistas.dto.DeporteDto;
import com.bootcamp.ejercicio_deportistas.service.IService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    IService service;

    public Controller(IService service) {
        this.service = service;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDto>> getSports(){
        return ResponseEntity
                .ok()
                .body(service.getAllSports());
    }
}
