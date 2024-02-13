package com.mercadolibre.starwars.repository;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.base.Characters;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepoImp implements  ICharacterRepo {

    private List<Characters> characterList;


    public CharacterRepoImp(){
        this.characterList =new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            File jsonFile = null;
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            characterList = mapper.readValue(jsonFile , new TypeReference<List<Characters>>(){}  );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Characters> getCharacterByName(String value) {
        return this.characterList.stream().filter( x-> x.getName().toLowerCase().contains(value.toLowerCase())).toList();
    }

    @Override
    public List<Characters> gerAll() {
        return this.characterList;
    }
}
