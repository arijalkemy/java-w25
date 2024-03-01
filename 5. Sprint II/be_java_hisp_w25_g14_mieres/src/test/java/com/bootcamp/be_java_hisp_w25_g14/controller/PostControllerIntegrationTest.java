package com.bootcamp.be_java_hisp_w25_g14.controller;

import com.bootcamp.be_java_hisp_w25_g14.dto.MessageDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.PostDto;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.InvalidRequestException;
import com.bootcamp.be_java_hisp_w25_g14.utils.HelperFunctions;
import com.bootcamp.be_java_hisp_w25_g14.utils.ObjectFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("T0009 - Get All Posts OK")
    void getAllPostsIntegrationTest() throws Exception {
        mockMvc.perform(get("/products/getAllPosts"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @DisplayName("T0010 - GetFollowedPostsLastTwoWeeks OK")
    void getFollowedPostsLastTwoWeeksIntegrationTest() throws Exception {
        String userId = "1";

        mockMvc.perform(get(String.format("/products/followed/%s/list",userId)))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @DisplayName("T0011 - SavePost OK")
    void savePostIntegrationTest() throws Exception {
        //Arrange
        try{
            //Create and serialize request object
            PostDto postDto = ObjectFactory.generatePostDto(56,1,"25-02-2024");
            String requestBody = HelperFunctions.serializeObject(postDto);

            //Serialize expected success message
            MessageDto messageDto = new MessageDto("Post added", "The post was added succesfully");
            String expectedResult = HelperFunctions.serializeObject(messageDto);

            //Act & Assert
            MvcResult mvcResult = mockMvc.perform(post("/products/post")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(requestBody))
                    .andDo(print())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(status().isOk())
                    .andReturn();

            assertEquals(expectedResult,mvcResult.getResponse().getContentAsString());
        }catch (JsonProcessingException ex){
            throw new InvalidRequestException("Something is wrong with the request object");
        }

    }

}
