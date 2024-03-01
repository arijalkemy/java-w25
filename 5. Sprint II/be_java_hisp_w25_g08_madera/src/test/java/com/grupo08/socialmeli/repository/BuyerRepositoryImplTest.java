package com.grupo08.socialmeli.repository;

import com.grupo08.socialmeli.entity.Buyer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BuyerRepositoryImplTest {

    @InjectMocks
    BuyerRepositoryImpl buyerRepository;
    @Test
    void findAll() {
        //arrange
        int expectedSize = 6;

        //act
        List<Buyer> buyers = buyerRepository.findAll();

        //verify
        assertNotNull(buyers);
        assertEquals(expectedSize,buyers.size());
    }

    @Test
    @DisplayName("Se encuentra usuario por id")
    void findById() {
        //arrange
        int userId = 1;
        String expectedName = "Fabian";

        //act
        Optional<Buyer> buyer =
                buyerRepository.findById(userId);

        //assert
        assertTrue(buyer.isPresent());
        assertEquals(userId,buyer.get().getId());


    }

    @Test
    @DisplayName("No se encuentra usuario por id")
    void findByIdNotFound() {
        //arrange
        int userId = 100000065;

        //act
        Optional<Buyer> buyer =
                buyerRepository.findById(userId);

        //assert
        assertTrue(buyer.isEmpty());
    }
}