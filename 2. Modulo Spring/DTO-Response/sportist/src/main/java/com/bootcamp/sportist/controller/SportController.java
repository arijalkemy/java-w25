package com.bootcamp.sportist.controller;

import com.bootcamp.sportist.SportistApplication;
import com.bootcamp.sportist.dto.response.AllSportsDTO;
import com.bootcamp.sportist.dto.response.SingleSportDTO;
import com.bootcamp.sportist.dto.response.SportsPersonDTO;
import com.bootcamp.sportist.model.Sport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SportController {

    @GetMapping("/findSports")
    public ResponseEntity<AllSportsDTO> getAllSports(){
        AllSportsDTO allSportsDTO = new AllSportsDTO();
        allSportsDTO.setSportsList(SportistApplication.getSportsList());
        return new ResponseEntity<>(allSportsDTO, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<SingleSportDTO> getSportByName(@PathVariable String name){
        SingleSportDTO sportByName = new SingleSportDTO();
        Sport sport = SportistApplication.getSportsList().stream()
                .filter((x) -> x.getName().equals(name)).findFirst().orElse(null);
        sportByName.setSport(sport);
        return new ResponseEntity<>(sportByName, HttpStatus.OK);
    }

    @GetMapping("/findSportsPerson")
    public ResponseEntity<List<SportsPersonDTO>> getAllSportsPerson(){
        List<SportsPersonDTO> sportPersonaList = SportistApplication.getPersonsList().stream()
                .map(person -> new SportsPersonDTO(person.getName(), person.getLastName(), person.getSport()
                        .stream().map(Sport::getName).toList())).toList();
        return new ResponseEntity<>(sportPersonaList, HttpStatus.OK);
    }
}
