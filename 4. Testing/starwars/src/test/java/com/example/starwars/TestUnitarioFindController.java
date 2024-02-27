package com.example.starwars;

import com.example.starwars.controller.FindController;
import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestUnitarioFindController {
    @Mock
    FindService findService;
    @InjectMocks
    FindController findController;

    @Test
    public void getCharacterTestOK(){
        //ARRANGE
        List<CharacterDTO> expectedCharacters = new ArrayList<>(List.of());
        CharacterDTO luke =  new CharacterDTO();
        luke.setName("Luke Skywalker");
        CharacterDTO ani =  new CharacterDTO();
        ani.setName("Anakin Skywalker");
        CharacterDTO shmi =  new CharacterDTO();
        shmi.setName("Shmi Skywalker");

        expectedCharacters.add(luke);
        expectedCharacters.add(ani);
        expectedCharacters.add(shmi);

        when(findService.find("Skywalker")).thenReturn(expectedCharacters);
        //ACT
        List<CharacterDTO> charactersListFound = findController.find("Skywalker");
        //ASSERT
        assertThat(charactersListFound).isNotEmpty();
        assertThat(expectedCharacters).isEqualTo(charactersListFound);
    }

    @Test
    public void getCharacterTestEmptyOrNotFound(){
        //ARRANGE
        List<CharacterDTO> expectedCharacters = new ArrayList<>();
        //ACT
        List<CharacterDTO> charactersListFound = findController.find("djbhjbdbhd");
        //ASSERT
        //assertThat(charactersListFound).isEqualTo(expectedCharacters);
        assertThat(charactersListFound).isEmpty();
    }
}
