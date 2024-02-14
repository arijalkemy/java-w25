package com.example.deportistas.controller;

import com.example.deportistas.dto.response.DeporteDTO;
import com.example.deportistas.dto.response.DeporteListDTO;
import com.example.deportistas.models.Deporte;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DeporteController {

    @GetMapping("/findSports")
    public ResponseEntity<DeporteListDTO> getDeportes() {
        DeporteListDTO deporteDTO = new DeporteListDTO();
        deporteDTO.setDeportes(List.of(new Deporte("Futbol", 5), new Deporte("Basket", 3), new Deporte("Tenis", 4)));
        return ResponseEntity.ok(deporteDTO);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> findSportByName(@PathVariable String name) {
      List<Deporte> sportsList =  List.of(new Deporte("Futbol", 5), new Deporte("Basket", 3), new Deporte("Tenis", 4));
        Optional<Deporte> deporte = sportsList.stream().filter(sport -> sport.getNombre().equals(name)).findFirst();
           if(deporte.isEmpty()){
                return ResponseEntity.notFound().build();
            }
        DeporteDTO deporteFindByNameDTO = new DeporteDTO();
        deporteFindByNameDTO.setNivel(deporte.get().getNivel());
        return ResponseEntity.ok(deporteFindByNameDTO);
    }


}
