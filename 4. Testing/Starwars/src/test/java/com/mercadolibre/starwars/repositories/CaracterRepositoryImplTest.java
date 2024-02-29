package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;



@SpringBootTest
public class CaracterRepositoryImplTest {

    @Autowired
    CharacterRepositoryImpl characterRepository;

    @Test
    void findAllByNameContainsOKTest() {

        List<CharacterDTO> expected = getSameNameCharacterList();


        List<CharacterDTO> actual = characterRepository.findAllByNameContains(
                "Darth");

        assertEquals(expected, actual);
    }

    private List<CharacterDTO> getSameNameCharacterList() {
        return List.of(
                getCaracterWithNameInBD1(),
                getCaracterWithNameInBD2()
        );
    }

    private CharacterDTO getCaracterWithNameInBD1() {
        return new CharacterDTO(
                "Darth Vader",
                "none",
                "white",
                "yellow",
                "41.9BBY",
                "male",
                "Tatooine",
                "Human",
                202,
                136);
    }

    private CharacterDTO getCaracterWithNameInBD2() {
        return new CharacterDTO(
                "Darth Maul",
                "none",
                "red",
                "yellow",
                "54BBY",
                "male",
                "Dathomir",
                "Zabrak",
                175,
                80);
    }

}
