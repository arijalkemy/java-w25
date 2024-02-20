package com.example.ejercicioDeportista.controller;

import com.example.ejercicioDeportista.dto.PersonasDeportistaDTO;
import com.example.ejercicioDeportista.model.Deporte;
import com.example.ejercicioDeportista.services.FindSportPerson;
import com.example.ejercicioDeportista.services.findSports;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class deportistaController {

    public findSports getSports;
    public FindSportPerson listaPersonas;

    public deportistaController() {
        this.getSports = new findSports(new ArrayList<>());
        this.listaPersonas = new FindSportPerson(new ArrayList<>());
    }


    @GetMapping("/findSports")
    public List<Deporte> obtenerDeportes(){
        return getSports.findSports();
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<?> existSport(@PathVariable String name){
        if (getSports.findSports().stream().anyMatch(deporte -> deporte.getNombre().equals(name))) {
            Optional<String> nivel = getSports.findSports().stream()
                    .filter(deporte -> deporte.getNombre().equals(name))
                    .map(deporte -> String.valueOf(deporte.getNivel()))
                    .findFirst();
            String mensaje = "Existe el deporte: " + name + ", Nivel: " + nivel.get();
            return ResponseEntity.ok(mensaje);        }
        else {
            return new ResponseEntity<>("No existe un deporte con ese nombre", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findSportsPersons")
    public List<PersonasDeportistaDTO> obtenerPersonas(){
        return listaPersonas.FindSportPersons();
    }
}
