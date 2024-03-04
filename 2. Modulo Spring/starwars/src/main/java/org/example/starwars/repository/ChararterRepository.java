package org.example.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.starwars.character.CharacterModel;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Repository
public class ChararterRepository implements ICharacterRepository {
    private final String JSON_PATH = "database/starwars.json";
    private List<CharacterModel> dataSource;
    public ChararterRepository(){
        var mapper = new ObjectMapper();
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(this.JSON_PATH))
        {
            this.dataSource = mapper.readValue(inputStream, new TypeReference<List<CharacterModel>>() {});
        }catch (IOException exception){
            throw new RuntimeException("Error Opening json data source",exception);
        }
    }

    @Override
    public List<CharacterModel> findAllByNameLike(String like) {
        List<Integer> testing = Arrays.asList();
        testing.add(23);
        System.out.println(testing);
        return this.dataSource.stream()
                .filter(characterModel -> characterModel.getName().toUpperCase().contains(like.toUpperCase())).toList();
    }
}
