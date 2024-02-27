package com.mercadolibre.starwars.repository;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Test
    void findAllByNameCotainsOK(){
        String nameExpected = "Luke Skywalker";

        List<CharacterDTO> response = characterRepository.findAllByNameContains("Luke");

        System.out.println(response.get(0).getName());
        Assertions.assertEquals(nameExpected, response.get(0).getName());
        Assertions.assertEquals(1,response.size());
    }

}
