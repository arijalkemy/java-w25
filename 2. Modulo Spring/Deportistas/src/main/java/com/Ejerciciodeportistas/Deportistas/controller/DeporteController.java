package com.Ejerciciodeportistas.Deportistas.controller;


import com.Ejerciciodeportistas.Deportistas.Deporte;
import com.Ejerciciodeportistas.Deportistas.Persona;
import com.Ejerciciodeportistas.Deportistas.dto.DeporteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeporteController {

    private List<Deporte> deportes = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

    public DeporteController() {
        // Inicialización de deportes y personas
        Deporte futbol = new Deporte("Futbol", "Avanzado");
        Deporte tenis = new Deporte("Tenis", "Intermedio");
        deportes.add(futbol);
        deportes.add(tenis);

        Persona persona1 = new Persona("Juan", "Perez", 30, futbol);
        Persona persona2 = new Persona("Maria", "Lopez", 25, tenis);
        personas.add(persona1);
        personas.add(persona2);
    }

    @GetMapping("/findSports")
    public List<Deporte> findSports() {
        return deportes;
    }


    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name){
        for (Deporte deporte : deportes){
            if(deporte.getNombre().equals(name)){
                return ResponseEntity.ok(deporte.getNivel());
            }

        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/addPerson")
    public ResponseEntity<String> addPerson(@RequestBody Persona persona) {
        Deporte deportePersona = persona.getDeporte();
        if (!deportes.contains(deportePersona)) {
            deportes.add(deportePersona);
        }
        personas.add(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body("Persona agregada correctamente!");
    }

    @GetMapping("/findSportsPersons")
    public List<DeporteDTO> findSportsPersons() {
        List<DeporteDTO> deportesPersonas = new ArrayList<>();
        for (Persona persona : personas) {
            DeporteDTO dto = new DeporteDTO();
            dto.setNombre(persona.getNombre());
            dto.setApellido(persona.getApellido());
            dto.setNombreDeporte(persona.getDeporte().getNombre());
            deportesPersonas.add(dto);
        }
        return deportesPersonas;
    }

}
