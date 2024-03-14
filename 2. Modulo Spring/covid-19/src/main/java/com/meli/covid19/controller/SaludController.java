package com.meli.covid19.controller;

import com.meli.covid19.dto.PersonaRiesgoDTO;
import com.meli.covid19.entity.Sintoma;
import com.meli.covid19.service.SaludService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaludController {

    @Autowired
    private SaludService saludService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> findAllSymptoms() {
        return ResponseEntity.ok(saludService.findAllSymptoms());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findSymptomByName(@PathVariable String name) {
        Sintoma sintoma = saludService.findSymptomByName(name);
        if (sintoma == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sintoma.getNivelDeGravedad());
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaRiesgoDTO>> findRiskPersons() {
        return ResponseEntity.ok(saludService.findRiskPersons());
    }
}