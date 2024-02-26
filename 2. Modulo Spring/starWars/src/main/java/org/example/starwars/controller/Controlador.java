package org.example.starwars.controller;

import org.example.starwars.dto.PersonajeDTO;
import org.example.starwars.service.Servicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controlador {
    private Servicio s;

    public Controlador(Servicio s) {
        this.s = s;
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> buscar(@PathVariable String nombre) {
        return s.responder(nombre);
    }
}
