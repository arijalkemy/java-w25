package com.meli.firstcontroller.sportsDTOPractice;

import com.meli.firstcontroller.sportsDTOPractice.dto.response.DeportistaDTO;
import com.meli.firstcontroller.sportsDTOPractice.dto.response.DeporteNivelDTO;
import com.meli.firstcontroller.sportsDTOPractice.dto.response.DeporteDTO;
import com.meli.firstcontroller.sportsDTOPractice.service.DeporteService;
import com.meli.firstcontroller.sportsDTOPractice.service.DeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SportsController {

    private final DeporteService deporteService;
    private final DeportistaService deportistaService;

    @Autowired
    public SportsController(DeporteService deporteService, DeportistaService deportistaService) {
        this.deporteService = deporteService;
        this.deportistaService = deportistaService;
    }

    @GetMapping(value = "/findSport/{name}")
    public ResponseEntity<DeporteNivelDTO> getSportByName(@PathVariable String name) {
        DeporteNivelDTO result = deporteService.getSportByName(name);
        if (result == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(deporteService.getSportByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/findSports")
    public ResponseEntity<List<DeporteDTO>> getAllSports() {
        return new ResponseEntity<>(deporteService.getSports(), HttpStatus.OK);
    }

    @GetMapping(value = "/findSportsPerson")
    public ResponseEntity<List<DeportistaDTO>> getSportPeople() {
        return new ResponseEntity<>(deportistaService.getPersonsWSport(), HttpStatus.OK);
    }

}
