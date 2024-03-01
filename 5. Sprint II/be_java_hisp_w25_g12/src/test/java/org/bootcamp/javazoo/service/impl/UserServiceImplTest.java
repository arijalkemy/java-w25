package org.bootcamp.javazoo.service.impl;
import org.bootcamp.javazoo.dto.response.MessageDto;
import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.entity.User;
import org.bootcamp.javazoo.exception.NotFoundException;
import org.bootcamp.javazoo.util.MockBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @InjectMocks
    UserServiceImpl userService;

    @Mock
    FindServiceImpl findService;

    @Test
    @DisplayName("unfollow Seller ok")
    public void unfollowUser() {
        //Arrange
        User user = MockBuilder.usersBuilder().get(0);
        Integer userId = user.getId();

        Seller seller = MockBuilder.sellersBuilder().get(0);
        Integer sellerId = seller.getId();
        when(findService.getUserById(userId)).thenReturn(user);
        when(findService.getSellerById(sellerId)).thenReturn(seller);
        MessageDto expected = new MessageDto("You stopped following the seller");

        //Act
        MessageDto response = userService.unfollowSeller(userId, sellerId);

        //Assert
        assertEquals(expected, response);
    }

    @Test
    @DisplayName("unfollow Seller when user don't follow the seller")
    public void unfollowUserException() {
        //Arrange
        User user = MockBuilder.usersBuilder().get(0);
        Integer userId = user.getId();

        Seller seller = MockBuilder.sellersBuilder().get(3);
        Integer sellerId = seller.getId();
        when(findService.getUserById(userId)).thenReturn(user);
        when(findService.getSellerById(sellerId)).thenReturn(seller);

        //Act && Assert
        assertThrows(NotFoundException.class, () -> userService.unfollowSeller(userId, sellerId));
    }
}
