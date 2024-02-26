package com.mercadolibre.starwars.respository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterRepositoryTest {

    private CharacterRepository characterRepository;

    @BeforeEach
    void setUp() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Find character by name (Repository) - Luke Success")
    void findAllByNameContainsTest() {
        String query = "Luke";
        List<CharacterDTO> allCharacters = characterRepository.findAllByNameContains(query);

        assertThat(allCharacters).isNotNull().isNotEmpty();
    }

    @Test
    @DisplayName("Find character by name (Repository) - Javan Error")
    void findAllByNameContainsErrorTest() {
        String query = "Javan";
        List<CharacterDTO> allCharacters = characterRepository.findAllByNameContains(query);

        assertThat(allCharacters).isEmpty();
    }
}
