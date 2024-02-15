package main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.DTO.*;
import main.model.*;

@RestController
@RequestMapping("/api")

public class DeporteController {
    private List<Deporte> listaDeportes = new ArrayList<>();
    private List<Persona> listPersonas = new ArrayList<>();

    DeporteController() {
        Deporte natacion = new Deporte("Natación", 1);
        Deporte futbol = new Deporte("Futbol", 2);
        this.listaDeportes.add(futbol);
        this.listaDeportes.add(natacion);

        Persona persona1 = new Persona("nombre1", "apellido1", 19, futbol);
        Persona persona2 = new Persona("nombre2", "apellido2", 19, natacion);
        this.listPersonas.add(persona1);
        this.listPersonas.add(persona2);
    }

    // 1
    @GetMapping("/findSports")
    @ResponseBody
    public ResponseEntity<List<DeporteDTO>> findSports() {
        List<DeporteDTO> lista = new ArrayList<>();
        for (int i = 0; i < this.listaDeportes.size(); i++) {
            lista.add(new DeporteDTO(listaDeportes.get(i).getNombre(), listaDeportes.get(i).getNivel()));
        }
        return new ResponseEntity<>(lista, HttpStatusCode.valueOf(200));
    }

    // 2
    @GetMapping("/findSports/{name}")
    @ResponseBody
    public ResponseEntity<DeporteNivelDTO> findSportsName(@PathVariable String name) {
        int level = -1;
        for (int i = 0; i < listaDeportes.size(); i++) {
            if (listaDeportes.get(i).getNombre().equals(name)) {
                level = listaDeportes.get(i).getNivel();
            }
        }
        return new ResponseEntity<>(new DeporteNivelDTO(level), HttpStatusCode.valueOf(200));
    }

    // 3
    @GetMapping("findSportsPersons")
    @ResponseBody
    public ResponseEntity<List<DeportePersonaDTO>> deportePersonaRelacion() {
        List<DeportePersonaDTO> list = new ArrayList<>();
        for (int i = 0; i < this.listPersonas.size(); i++) {
            list.add(new DeportePersonaDTO(listPersonas.get(i).getNombre(), listPersonas.get(i).getApellido(),
                    listPersonas.get(i).getDeporte().getNombre()));
        }
        return new ResponseEntity<>(list, HttpStatusCode.valueOf(200));
    }

}
