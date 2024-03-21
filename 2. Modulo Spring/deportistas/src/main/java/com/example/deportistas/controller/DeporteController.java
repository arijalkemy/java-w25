package com.example.deportistas.controller;

import com.example.deportistas.dto.response.DeporteDTO;
import com.example.deportistas.dto.response.DeporteListDTO;
import com.example.deportistas.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeporteController {

    @Autowired
    DeporteService deporteService;

    @GetMapping("/findSports")
    public ResponseEntity<DeporteListDTO> getDeportes() {
        return ResponseEntity.ok(deporteService.getDeportes());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> findSportByName(@PathVariable String name) {
        return ResponseEntity.ok(deporteService.findSportByName(name));
    }


}
