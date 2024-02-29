package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
public class FindServiceTest {

    @Mock
    private CharacterRepositoryImpl characterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    void findOKTest() {
        //Arrange
        String query = "Luke";
        List<CharacterDTO> expectedList = List.of(
            TestUtilsGenerator.getLukeSkywalker()
        );
        when(characterRepository.findAllByNameContains(query)).thenReturn(expectedList);

        //Act
        List<CharacterDTO> obtainedList = findService.find(query);

        //Assert
        verify(characterRepository, atLeastOnce()).findAllByNameContains(query);
        assertEquals(expectedList, obtainedList);
    }
}
