package com.mercadolibre.starwars.services;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FindServiceTest {

    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;

    @Test
    public void findCharactersSuccess(){
        List<CharacterDTO> characterDTOS = List.of(
                new CharacterDTO(
                        "Darth Vader",
                        "none",
                        "white",
                        "yellow",
                        "41.9BBY",
                        "male",
                        "Tatooine",
                        "Human",
                        202,
                        136),
                new CharacterDTO(
                        "Darth Maul",
                        "none",
                        "red",
                        "yellow",
                        "54BBY",
                        "male",
                        "Dathomir",
                        "Zabrak",
                        175,
                        80
                )
        );

        when(service.find("Darth")).thenReturn(characterDTOS);

        List<CharacterDTO> characters = service.find("Darth");

        assertSame(characters,characterDTOS);
    }
}
