package org.bootcamp.javazoo.service.impl;

import org.bootcamp.javazoo.dto.response.CountFollowersDto;
import org.bootcamp.javazoo.dto.response.MessageDto;
import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.entity.User;
import org.bootcamp.javazoo.exception.NotFoundException;
import org.bootcamp.javazoo.service.interfaces.IFindService;
import org.bootcamp.javazoo.util.MockBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SellerServiceImplTest {

    @Mock
    IFindService findService;

    @InjectMocks
    SellerServiceImpl sellerService;

    @Test
    @DisplayName("T0001 getSellerById -> when seller is found then return seller")
    public void getSellerByIdTest() {
        //Arrange
        Seller seller = MockBuilder.sellersBuilder().get(1);
        User user = MockBuilder.usersBuilder().get(1);
        Integer userId = user.getId();
        Integer sellerId = seller.getId();

        when(findService.getUserById(userId)).thenReturn(user);
        when(findService.getSellerById(any(Integer.class))).thenAnswer(invocation -> {
            int sId = invocation.getArgument(0);
            Seller s = new Seller();
            s.setId(sId);

            return s;
        });

        //act
        MessageDto result = sellerService.addFollow(userId, sellerId);

        //assert
        verify(findService, times(1)).getUserById(userId);
        verify(findService, times(1)).getSellerById(sellerId);
        assertNotNull(result);
    }

    @Test
    @DisplayName("T0001 getSellerById -> when seller is not found then throw NotFoundException")
    public void getSellerByIdNotFoundTest() {
        // Arrange
        int sellerId = 1;
        User user = MockBuilder.usersBuilder().get(1);
        Integer userId = user.getId();

        when(findService.getUserById(userId)).thenReturn(user);
        when(findService.getSellerById(eq(sellerId))).thenThrow(new NotFoundException("Seller not found"));

        // Act and Assert
        assertThrows(NotFoundException.class, () -> {
            sellerService.addFollow(userId, sellerId);
        });

        // Verify
        verify(findService, times(1)).getUserById(userId);
        verify(findService, times(1)).getSellerById(sellerId);
    }
    @Test
    @DisplayName("T0007 getFollowersListCount -> Number of followers is correct")
    void getFollowersListCount() {
        //Arrange
        int userId = 1;
        Seller seller = MockBuilder.sellersBuilder().get(0);
        when(findService.getSellerById(userId)).thenReturn(seller);

        //Act
        CountFollowersDto countResult = sellerService.getFollowersListCount(userId);

        //Assert
        assertEquals(seller.getFollowers().size(), countResult.getFollowers_count());
    }
}