package com.mercadolibre.w25.services;

import com.mercadolibre.w25.dto.SportDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportsService {

    private List<SportDto> sportDaoList= new ArrayList<>();


    public List<SportDto> getAllSports(){
        return sportDaoList;
    }

    public void addSport(SportDto sport){
        sportDaoList.add(sport);
    }

    public SportDto findByName(String name){
        return  sportDaoList.stream().filter(x-> x.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

}
