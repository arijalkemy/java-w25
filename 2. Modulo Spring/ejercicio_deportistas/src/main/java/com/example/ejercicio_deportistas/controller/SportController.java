package com.example.ejercicio_deportistas.controller;

import com.example.ejercicio_deportistas.dto.LevelDTO;
import com.example.ejercicio_deportistas.dto.SportDTO;
import com.example.ejercicio_deportistas.service.ISportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {
    ISportService sportService;

    public SportController(ISportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDTO>> findAll(){
        return new ResponseEntity<>(sportService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<LevelDTO> findSportLevel(@PathVariable("name") String name){
        return new ResponseEntity<>(sportService.getSportLevel(name), HttpStatus.OK);
    }
}
