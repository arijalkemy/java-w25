package com.practicaEjerciciosp1Vivo.deportistas.controller;

import com.practicaEjerciciosp1Vivo.deportistas.dto.DeportistasDTO;
import com.practicaEjerciciosp1Vivo.deportistas.logic.DeportistasLogic;
import com.practicaEjerciciosp1Vivo.deportistas.model.Deporte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistasController {
    DeportistasLogic deportistasLogic = new DeportistasLogic();

    @GetMapping ("/findSports")
    public List<Deporte> getAllSports(){
        return deportistasLogic.getAllSports();
    }

    @GetMapping ("/findSport/{name}")
    public Deporte searchSport(@PathVariable String name){
        Deporte deporte = deportistasLogic.searchSport(name);
        return deporte;
    }

    @GetMapping ("/findSportsPersons")
    public ResponseEntity<List<DeportistasDTO>> getAllPersons(){
        return new ResponseEntity<>(deportistasLogic.getPersonsSport(), HttpStatus.OK);
    }
}
