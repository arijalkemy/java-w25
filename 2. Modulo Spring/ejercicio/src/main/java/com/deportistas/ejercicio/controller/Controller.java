package com.deportistas.ejercicio.controller;

import com.deportistas.ejercicio.data.Deporte;
import com.deportistas.ejercicio.data.Persona;
import com.deportistas.ejercicio.dto.DeporteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    private List<Deporte> deportes = new ArrayList<>(List.of(new Deporte("Futbol", "Intermedio"), new Deporte("VolleyBall", "Alto")));
    private List<Persona> personas = new ArrayList<>(List.of(new Persona("Fabian","Rodriguez",21),new Persona("Test","Test",16), new Persona("Prueba","Prueba",26)));


    @GetMapping("/findSports")
    public List<Deporte> findDeportes(){
        return  deportes;
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findByName(@PathVariable String name){
        for (Deporte deporte : deportes) {
            if (deporte.getNombre().equalsIgnoreCase(name)) {
                return new ResponseEntity<>(deporte.getNivel(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Deporte no encontrado", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findSportPersons")
    public List<DeporteDTO> findSportPersosns(){

        List<DeporteDTO> deportesDTO = new ArrayList<>();
        for(Persona persona: personas){
            String nombrePersona= persona.getNombre();
            String apellidoPersona = persona.getApellido();
            String nombreDeporte="";
            DeporteDTO deporteDTO=new DeporteDTO(nombrePersona + " "+apellidoPersona, nombreDeporte);
            deportesDTO.add(deporteDTO);
        }
        return deportesDTO;
    }





}
