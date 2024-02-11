package com.bootcamp.Deportistas.Controller;

import com.bootcamp.Deportistas.DTO.DeporteDTO;
import com.bootcamp.Deportistas.DTO.Deportista;
import com.bootcamp.Deportistas.Model.Deporte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DeportesController {
    private final static List<DeporteDTO> deportes = new ArrayList<>(List.of(new DeporteDTO("Futbol", 1), new DeporteDTO("Basquet", 1), new DeporteDTO("Tenis", 2)));
    ;private final static List<Deportista> deportistas = new ArrayList<>(List.of(new Deportista("juan", "perez", "Futbol")));
    @GetMapping("/findSport")
    public ResponseEntity<List<DeporteDTO>> getDeportes(){
    return new ResponseEntity<>(deportes, HttpStatus.OK);
    }
    @GetMapping("/findSport/{name}")
    public  ResponseEntity<Integer> getDeportesByName(@PathVariable String name){
        Optional<DeporteDTO> deporteFiltrado = deportes.stream().filter(deporte -> deporte.getNombre().equals( name)).findFirst();
        return deporteFiltrado.map(deporteDTO -> new ResponseEntity<>(deporteDTO.getNivel(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(-1, HttpStatus.NO_CONTENT));
    }
    @GetMapping("/findSportsPerson")
    public ResponseEntity<List<Deportista>> getDeportistas(){
        return new ResponseEntity<>(deportistas, HttpStatus.OK);
    }
}
