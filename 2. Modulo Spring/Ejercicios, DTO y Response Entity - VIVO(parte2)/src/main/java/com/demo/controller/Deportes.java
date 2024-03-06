package com.demo.controller;
import com.demo.dto.DeporteDTO;
import com.demo.model.Deporte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class Deportes {

    List<Deporte> deporteList = List.of(
            new Deporte("tenis",4),
            new Deporte("futbol",4),
            new Deporte("baloncesto",4),
            new Deporte("natación",5),
            new Deporte("ciclismo",5),
            new Deporte("volleyball",4)
    );

    @GetMapping("/findSports")
    public List<Deporte> allSports(){
        return deporteList;
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeporteDTO> oneSport(@PathVariable String name){
        Optional<Deporte> deporteEncontrado = deporteList.stream().filter(deporte -> deporte.getNombre().equals(name)).findFirst();

        if (deporteEncontrado.isPresent()) {
            return new ResponseEntity<>(new DeporteDTO(deporteEncontrado.get().getNivel()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}