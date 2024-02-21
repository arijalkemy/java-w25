package com.springlh.starwars_sala2.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springlh.starwars_sala2.dto.CharacterDTO;
import com.springlh.starwars_sala2.entity.StarWarsCharacter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class CharacterRepositoryImp implements CharacterRepository {

    List<StarWarsCharacter> starWarsCharacterDatabase;

    public CharacterRepositoryImp() {
        this.starWarsCharacterDatabase = loadDatabase();
    }

    private List<StarWarsCharacter> loadDatabase() {
        // cargar archivo con data json
        File file = null;
        try {
            file = ResourceUtils.getFile("target/starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // herramientas para mapear
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<StarWarsCharacter>> typeRef = new TypeReference<>() {
        };
        List<StarWarsCharacter> starWarsCharacters = null;
        try {
            // leer datos json y mapear a lista de ingredientes
            starWarsCharacters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return starWarsCharacters;
    }

    @Override
    public List<StarWarsCharacter> findByName(String name) {
        return starWarsCharacterDatabase
                .stream()
                .filter(starWarsCharacter -> starWarsCharacter.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    //JSONArray a = (JSONArray) parser.parse(new FileReader(".."));
}
