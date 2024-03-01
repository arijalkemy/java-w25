package org.bootcamp.javazoo.helper;

import org.bootcamp.javazoo.dto.PostResponseDto;
import org.bootcamp.javazoo.dto.UserDto;
import org.bootcamp.javazoo.exception.BadRequestException;
import org.bootcamp.javazoo.repository.impl.PostRepositoryImpl;
import org.bootcamp.javazoo.service.impl.PostServiceImpl;
import org.bootcamp.javazoo.service.impl.UserServiceImpl;
import org.bootcamp.javazoo.util.MockBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CollectionSorterTest {

    @Test
    @DisplayName("T0004 sortTypeExists -> Sort type by name asc")
    void sortUserDtoCollectionByNameAscTest() {
        //Arrange
        List<UserDto> userDtoList = new ArrayList<>();
        UserDto userDto = new UserDto(1, "Luke Skywalker");
        UserDto userDto2 = new UserDto(2, "Leia Organa");
        userDtoList.add(userDto);
        userDtoList.add(userDto2);
        String order = "name_asc";
        List<UserDto> userDtoSortedList = userDtoList.stream().sorted(Comparator.comparing(UserDto::getUser_name)).toList();

        //Act
        List<UserDto> userDtoResult = CollectionSorter.sortUserDtoCollection(userDtoList, order);

        //Assert
        assertEquals(userDtoSortedList, userDtoResult);
    }

    @Test
    @DisplayName("T0004 sortTypeExists -> Sort type by name desc")
    void sortUserDtoCollectionByNameDescTest() {
        //Arrange
        List<UserDto> userDtoList = new ArrayList<>();
        UserDto userDto = new UserDto(1, "Luke Skywalker");
        UserDto userDto2 = new UserDto(2, "Leia Organa");
        userDtoList.add(userDto);
        userDtoList.add(userDto2);
        String order = "name_desc";
        List<UserDto> userDtoSortedList = userDtoList.stream().sorted(Comparator.comparing(UserDto::getUser_name).reversed()).toList();

        //Act
        List<UserDto> userDtoResult = CollectionSorter.sortUserDtoCollection(userDtoList, order);

        //Assert
        assertEquals(userDtoSortedList, userDtoResult);
    }

    @Test
    @DisplayName("T0003 sortTypeExists -> Sort type Invalid")
    void sortUserDtoCollectionInvalidTest() {
        //Arrange
        List<UserDto> userDtoList = new ArrayList<>();
        UserDto userDto = new UserDto(1, "Luke Skywalker");
        UserDto userDto2 = new UserDto(2, "Leia Organa");
        userDtoList.add(userDto);
        userDtoList.add(userDto2);
        String order = "cadcad";

        //Act & Assert
        assertThrows(BadRequestException.class, () -> CollectionSorter.sortUserDtoCollection(userDtoList, order));
    }

    @Test
    @DisplayName("T0006 -> sort post by date ascendent")
    void sortPostDtoByDateAscTest () {

        //Arrange
        String order = "date_asc";
        Integer sellerId = 2;
        List<PostResponseDto> request = (MockBuilder.postsBuilder()).stream()
                .map(post -> Mapper.mapToPostDto(post, sellerId)).toList();
        List<PostResponseDto> expected = CollectionSorter.sortPostDtoByDate(request, order);

        //Act
        List<PostResponseDto> result = CollectionSorter.sortPostDtoByDate(request, order);

        //Assert
        Assertions.assertEquals(expected, result);

    }

    @Test
    @DisplayName("T0006 -> sort post by date descendent")
    void sortPostDtoByDateDescTest () {

        //Arrange
        String order = "date_desc";
        Integer sellerId = 2;
        List<PostResponseDto> request = (MockBuilder.postsBuilder()).stream()
                .map(post -> Mapper.mapToPostDto(post, sellerId)).toList();
        List<PostResponseDto> expected = CollectionSorter.sortPostDtoByDate(request, order);

        //Act
        List<PostResponseDto> result = CollectionSorter.sortPostDtoByDate(request, order);

        //Assert
        Assertions.assertEquals(expected, result);

    }

    @Test
    @DisplayName("T0005 -> sort post by invalid order")
    void sortPostDtoByDateInvalidTest () {

        //Arrange
        String order = "date_dasda";
        Integer sellerId = 2;
        List<PostResponseDto> request = (MockBuilder.postsBuilder()).stream()
                .map(post -> Mapper.mapToPostDto(post, sellerId)).toList();

        //Act & Assert
        assertThrows(BadRequestException.class, () -> CollectionSorter.sortPostDtoByDate(request, order));

    }

}