package com.miprimerproyecto.deportistas.controller;

import com.miprimerproyecto.deportistas.models.Deporte;
import com.miprimerproyecto.deportistas.dto.AthleteDTO;
import com.miprimerproyecto.deportistas.services.SportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sports")
public class SportsController {
    SportService sportService = new SportService();
    @GetMapping("/getAll")
    public ResponseEntity<List<Deporte>> findAllSports(){
        List<Deporte> sportsList = sportService.getAllSports();

        return new ResponseEntity<>(sportsList, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name){
        List<Deporte> sportsList = sportService.getAllSports();

        Optional<Deporte> sportFound = sportsList.stream().filter(sport-> sport.getNombre().equals(name)).findFirst();

        if(sportFound.isPresent()){
            return new ResponseEntity<>(sportFound.get().getNivel(),HttpStatus.OK);
        }else{
            throw new RuntimeException("Sport not found");
        }

    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<AthleteDTO>> findSportsPersons(){
        List<AthleteDTO> sportsList = sportService.getDTOs();

        return new ResponseEntity<>(sportsList,HttpStatus.OK);
    }
}
