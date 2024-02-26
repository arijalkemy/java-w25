package com.mercadolibre.starwars.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {
    public static List<CharacterDTO> buildExpectedLukeCharacters() {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {};
        List<CharacterDTO> characters = null;
        try{
            characters = objectMapper.readValue("[{\"name\": \"Luke Skywalker\",\n" +
                    "    \"height\": 172,\n" +
                    "    \"mass\": 77,\n" +
                    "    \"hair_color\": \"blond\",\n" +
                    "    \"skin_color\": \"fair\",\n" +
                    "    \"eye_color\": \"blue\",\n" +
                    "    \"birth_year\": \"19BBY\",\n" +
                    "    \"gender\": \"male\",\n" +
                    "    \"homeworld\": \"Tatooine\",\n" +
                    "    \"species\": \"Human\"}]", typeRef);
        }catch (JsonProcessingException e) {
            System.out.println("Need to manage JsonProcessingException in ObjectFactory");
        }
        return characters;
    }


}
