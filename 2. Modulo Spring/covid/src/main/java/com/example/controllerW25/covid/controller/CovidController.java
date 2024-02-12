package com.example.controllerW25.covid.controller;

import com.example.controllerW25.covid.dto.PersonaDeRiesgoDTO;
import com.example.controllerW25.covid.entity.Sintoma;
import com.example.controllerW25.covid.service.CovidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/covid")
public class CovidController {
    private final CovidService covidService;

    public CovidController(CovidService covidService) {
        this.covidService = covidService;
    }
    @GetMapping("/findSymptoms")
    public ResponseEntity<List<Sintoma>> findAllSymptoms() {
        return ResponseEntity.ok(covidService.findAllSymptoms());
    }
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Sintoma> findSymptom(@PathVariable String name) {
        return ResponseEntity.ok(covidService.findSymptom(name));
    }
    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDeRiesgoDTO>> findGrupoDeRiesgo() {
        return ResponseEntity.ok(covidService.findGrupoDeRiesgo());
    }
}
