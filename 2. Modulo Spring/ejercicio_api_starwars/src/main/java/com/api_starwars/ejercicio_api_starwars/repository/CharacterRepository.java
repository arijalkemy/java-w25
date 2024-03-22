package com.api_starwars.ejercicio_api_starwars.repository;

import com.api_starwars.ejercicio_api_starwars.dto.CharacterDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository implements ICharacterRepository{
    private final List<CharacterDTO> database;

    public CharacterRepository(){
        this.database=loadDatabase();
    }

    @Override
    public List<CharacterDTO> findAllByNameContains(String query){
        return  database.stream()
                .filter(characterDTO -> characterDTO.getName().toUpperCase().contains(query.toUpperCase()))
                .collect(Collectors.toList());
    }

    // Method to load data from JSON file
    private List<CharacterDTO> loadDatabase(){
        File file=null;

        // Get file from path
        try{
            file = ResourceUtils.getFile("classpath:config/characters.json");
            System.out.println("File"+ file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        // Set objects elements from json file to list
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {};
        List<CharacterDTO> characters = null;

        try{
            characters = objectMapper.readValue(file, typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }

        return characters;
    }
}
