package com.mercadolibre.w25.services;

import com.mercadolibre.w25.dto.AthleteDto;
import com.mercadolibre.w25.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AthleteService {
    @Autowired
    private SportsService sportsService;
    @Autowired
    private PersonServices personServices;
    public List<AthleteDto> getAthletes(){
        var sports = sportsService.getAllSports();
        var persons = personServices.getAllPerson();
        List<AthleteDto> athleteDaos = new ArrayList<>();


        Random random= new Random();
        for( PersonDto person: persons){
            String sportName =  sports.get(random.nextInt(sports.size())).getName();
            athleteDaos.add(new AthleteDto(person.getName(), person.getName() ,sportName ));
        }
        return  athleteDaos;
    }
}
