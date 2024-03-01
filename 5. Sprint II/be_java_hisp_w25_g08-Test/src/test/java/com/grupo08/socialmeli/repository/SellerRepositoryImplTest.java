package com.grupo08.socialmeli.repository;

import com.grupo08.socialmeli.entity.Seller;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SellerRepositoryImplTest {

    @InjectMocks
    SellerRepositoryImpl sellerRepository;

    @Test
    void findAll() {

        int sellerRepositorySize = 3;

        List<Seller> list = sellerRepository.findAll();

        assertNotNull(list);

        assertEquals(sellerRepositorySize, list.size());

    }

    @Test
    void findById() {

        int existingSellerId = 1;

        Optional<Seller> existingSeller = sellerRepository.findById(existingSellerId);

        assertTrue(existingSeller.isPresent());
        assertEquals(existingSellerId, existingSeller.get().getId());

    }
}