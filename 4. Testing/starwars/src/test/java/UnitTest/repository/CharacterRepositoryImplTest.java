package UnitTest.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterRepositoryImplTest {
    @Test
    void findAllByNameContainsOkTest(){
        //Arrange
        CharacterDTO character1 = new CharacterDTO();
        character1.setName("Luke Skywalker");
        character1.setHeight(172);
        character1.setMass(77);
        character1.setHair_color("blond");
        character1.setSkin_color("fair");
        character1.setEye_color("blue");
        character1.setBirth_year("19BBY");
        character1.setGender("male");
        character1.setHomeworld("Tatooine");
        character1.setSpecies("Human");
        List<CharacterDTO> charactersExpected = List.of(
                character1
        );

        CharacterRepository characterRepository = new CharacterRepositoryImpl();

        String querySearch = "Luke";

        //Act
        List<CharacterDTO> charactersResult = characterRepository.findAllByNameContains(querySearch);

        //Assert
        assertEquals(charactersExpected,charactersResult);
    }
}
