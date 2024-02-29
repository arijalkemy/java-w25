package org.bootcamp.javazoo.service;

import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.exception.NotFoundException;
import org.bootcamp.javazoo.repository.impl.SellerRepositoryImpl;
import org.bootcamp.javazoo.service.impl.FindServiceImpl;
import org.bootcamp.javazoo.util.MockBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindServiceUnitTest {
    @Mock
    private SellerRepositoryImpl sellerRepository;
    @InjectMocks
    private FindServiceImpl findService;

    @Test
    @DisplayName("T0002 getSellerById -> when seller is found then return seller")
    public void getSellerByIdTest() {
        //Arrange
        Seller seller = MockBuilder.sellersBuilder().get(0);
        Integer sellerId = seller.getId();
        when(sellerRepository.findById(sellerId)).thenReturn(seller);

        //act
        Seller actualSeller = findService.getSellerById(sellerId);

        //assert
        verify(sellerRepository, times(1)).findById(sellerId);
        assertEquals(seller.getName(), actualSeller.getName());
    }

    @Test
    @DisplayName("T0002 getSellerById -> when seller is not found then throw NotFoundException")
    public void getSellerByIdNotFoundTest() {
        //Arrange
        int sellerId = 1;
        when(sellerRepository.findById(sellerId)).thenReturn(null);

        //act and assert
        assertThrows(NotFoundException.class, () -> findService.getSellerById(sellerId));
    }
}
