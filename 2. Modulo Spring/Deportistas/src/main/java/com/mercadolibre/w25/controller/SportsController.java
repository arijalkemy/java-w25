package com.mercadolibre.w25.controller;

import com.mercadolibre.w25.dto.AthleteDto;
import com.mercadolibre.w25.dto.SportDto;
import com.mercadolibre.w25.services.AthleteService;
import com.mercadolibre.w25.services.SportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sports")
public class SportsController {

    @Autowired
    private SportsService sportsService;
    @Autowired
    private AthleteService athleteService;

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDto>> findSports(){
        return  new ResponseEntity<>(sportsService.getAllSports(), HttpStatus.OK);
    }

    @PostMapping("/addSport")
    public ResponseEntity<SportDto> addSport(@RequestBody SportDto sportDao){
        sportsService.addSport(sportDao);
        return  new ResponseEntity<>(sportDao, HttpStatus.OK);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<SportDto> findSportByName(@PathVariable String name){
        return new ResponseEntity<>(sportsService.findByName(name),HttpStatus.OK);
    }

    @GetMapping ("/findSportsPersons")
    public  ResponseEntity<List<AthleteDto>> findAthletes(){
        return  new ResponseEntity<>(athleteService.getAthletes(), HttpStatus.OK);
    }
}
