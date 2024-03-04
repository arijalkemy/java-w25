package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryTest {

    @Mock
    CharacterRepository characterRepository;

    @Test
    void findAllByNameContains() {
        String name = "Luke Skywalker";
        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(new CharacterDTO("Luke Skywalker","blond","fair","blue","19BBY","male","Tatooine","Human",172,77));

        when(characterRepository.findAllByNameContains(name)).thenReturn(expected);

        List<CharacterDTO> actual = characterRepository.findAllByNameContains(name);

        assertEquals(expected,actual);
    }
}