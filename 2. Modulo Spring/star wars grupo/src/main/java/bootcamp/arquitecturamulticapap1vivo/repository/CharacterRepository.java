package bootcamp.arquitecturamulticapap1vivo.repository;

import bootcamp.arquitecturamulticapap1vivo.entity.Character;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;




@Repository
public class CharacterRepository {

    public List<Character> getCharactersByName(String name) {

        List<Character> characters = new ArrayList<>();

        JSONParser jsonParser = new JSONParser();
        String fileName = "./starwars.json";

        try (FileReader reader = new FileReader(fileName)) {
            Object obj = jsonParser.parse(reader);

            JSONArray characterList = (JSONArray) obj;

            for (Object c : characterList) {
                Character character = parseCharacter((JSONObject) c);

                if (character.getName().contains(name)) characters.add(character);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Confiá que existe");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return characters;
    }

    private Character parseCharacter(JSONObject character) {
        String name = (String) character.get("name");
        Object heightString = character.get("height");
        Object massString = character.get("mass");
        String hairColor = (String) character.get("hair_color");
        String skinColor = (String) character.get("skin_color");
        String eyeColor = (String) character.get("eye_color");
        String birthYear = (String) character.get("birth_year");
        String gender = (String) character.get("gender");
        String homeworld = (String) character.get("homeworld");
        String species = (String) character.get("species");

        Integer height = parseInteger(heightString);
        Integer mass = parseInteger(massString);

        return Character.builder()
                .name(name)
                .height(height)
                .mass(mass)
                .hairColor(hairColor)
                .skinColor(skinColor)
                .eyeColor(eyeColor)
                .birthYear(birthYear)
                .gender(gender)
                .homeworld(homeworld)
                .species(species)
                .build();

    }

    private Integer parseInteger(Object integerObject) {
        String integerString;
        try {
            integerString = String.valueOf(integerObject);
        } catch (ClassCastException e) {
            return null;
        }
        int integer;
        try {
            integer = Integer.parseInt(integerString);
        } catch (NumberFormatException e) {
            return null;
        }
        return integer;
    }

}
