package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CharacterRepositoryImplTest {
    CharacterRepository characterRepository = new CharacterRepositoryImpl();
    @Test
    void findAllByNameContains() {
        String query = "Luke";

        List<CharacterDTO> charsFound = characterRepository.findAllByNameContains(query);

        Assertions.assertTrue(charsFound.size()==1
                && charsFound.get(0).getName().contains(query));
    }
}