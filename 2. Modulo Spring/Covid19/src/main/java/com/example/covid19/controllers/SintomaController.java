package com.example.covid19.controllers;

import com.example.covid19.models.Persona;
import com.example.covid19.models.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SintomaController {

    private List<Persona> lPersonas = new ArrayList<>();
    private List<Sintoma> lSintomas = new ArrayList<>();

    public SintomaController() {
        lPersonas.add(new Persona(1L, "Juan", "Pérez", 25));
        lPersonas.add(new Persona(2L, "María", "López", 30));
        lPersonas.add(new Persona(3L, "Carlos", "González", 22));

        lSintomas.add(new Sintoma(1, "Fiebre", "Moderado"));
        lSintomas.add(new Sintoma(2, "Tos seca", "Leve"));
        lSintomas.add(new Sintoma(3, "Dificultad para respirar", "Grave"));

    }

    @GetMapping
    public List<Sintoma> findSymptom() {
        return lSintomas;
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity findSymptomByName(@PathVariable String name) {
        for (Sintoma sintoma : lSintomas) {
            if (sintoma.getNombre().equals(name)) {
                return new ResponseEntity<>(sintoma.getNivel_de_gravedad(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Sintoma no encontrado", HttpStatus.NOT_FOUND);
    }
}
