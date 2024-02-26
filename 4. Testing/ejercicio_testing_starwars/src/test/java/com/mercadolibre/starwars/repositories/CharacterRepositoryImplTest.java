package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.util.TestGeneratorUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {

    CharacterRepository characterRepository;
    @BeforeEach
    public void setUp(){
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    void findAllByNameContains() {
        //arrange
        List<CharacterDTO> expectedCharacter = List.of(TestGeneratorUtil.getLuke());
        //act
        List<CharacterDTO> actualCharacter = characterRepository.findAllByNameContains("Luke");
        //assert
        assertTrue(CollectionUtils.isEqualCollection( expectedCharacter, actualCharacter));
    }


}