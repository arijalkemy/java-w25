package com.bootcamp.be_java_hisp_w25_g14.controller;

import com.bootcamp.be_java_hisp_w25_g14.dto.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w25_g14.service.UserServiceImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {
    @Mock
    UserServiceImp userService;
    @InjectMocks
    UserController userController;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("T0007 - Get Followers Count")
    void testGetUserFollowersCount() {
        // Mocking the behavior of UserService to return a specific UserFollowersCountDto
        UserFollowersCountDto userFollowersCountDto = new UserFollowersCountDto();
        userFollowersCountDto.setUser_id(1);
        userFollowersCountDto.setUser_name("testUser");
        userFollowersCountDto.setFollowers_count(10);

        // Configure the behavior of UserService mock to return the UserFollowersCountDto
        when(userService.getUserFollowersCount(1)).thenReturn(userFollowersCountDto);

        // Calling the controller method
        ResponseEntity<?> response = userController.getUserFollowersCount(1);

        // Verifying that UserService was called with the correct argument
        verify(userService).getUserFollowersCount(1);

        // Verifying that the response status is HttpStatus.OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verifying that the response body contains the expected UserFollowersCountDto
        assertEquals(userFollowersCountDto, response.getBody());
    }


    @Test
    @DisplayName("T001 Get Followers List")
    void getFollowersListTest() throws Exception{

        MvcResult mvcResult =
                this.mockMvc.perform(get("/users/{id}/followers/list",1)
                                .param("order", "name_asc"))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();
    }


}
