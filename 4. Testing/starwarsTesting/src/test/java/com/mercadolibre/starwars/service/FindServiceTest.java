package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class FindServiceTest {

    private final CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();
    private final FindService findService = new FindService(characterRepository);

    @Test
    void findCharacterOK(){
        String characterExpected = "Luke Skywalker";

        List<CharacterDTO> response = findService.find("Luke");

        Assertions.assertEquals(characterExpected,response.get(0).getName());
        Assertions.assertEquals(1,response.size());
    }

}
