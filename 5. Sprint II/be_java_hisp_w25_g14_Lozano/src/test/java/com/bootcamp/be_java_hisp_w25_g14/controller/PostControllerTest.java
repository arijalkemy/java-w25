package com.bootcamp.be_java_hisp_w25_g14.controller;

import com.bootcamp.be_java_hisp_w25_g14.dto.PostDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserFollowedPostDto;
import com.bootcamp.be_java_hisp_w25_g14.entity.Post;
import com.bootcamp.be_java_hisp_w25_g14.repository.PostRepoImp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {



    List<Post> postList;

    @Autowired
    MockMvc mockMvc;

    public PostControllerTest(){
        this.postList = new ArrayList<>();
        loadPosts();
    }

    @Test
    @DisplayName("T001 FindAllPostOk")

    void findAllPostOk() throws Exception{

        MvcResult result = mockMvc
                .perform(get("/products/getAllPosts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }


   /*@Test
    @DisplayName("T002 FindAllPost ")
    void findAllPostsTest() throws Exception {
    ObjectMapper maper = new ObjectMapper();

        //arrange
        List<Post> postListA = new ArrayList<>();
        postListA = postList;

        //act
        MvcResult result = mockMvc
                .perform(get("/products/getAllPosts"))
                .andDo(print())
                .andReturn();

        // Convierto la respuesta JSON a una lista de objetos de tipo Post
        List<Post> actualPostList = maper.readValue(result.getResponse().getContentAsString(),
                new TypeReference<List<Post>>() {});

        //assert
        Assertions.assertEquals(postListA, actualPostList);
    }*/

    @Test
    @DisplayName("T003 Validate status")
    void getFollowedPostsLastOkTest() throws Exception{

        mockMvc
                .perform(get("/products/followed/{userId}/list", 1)
                .param("order", "date_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }


    @Test
    @DisplayName("T004 validate Error")

    void getFollowedPostsLastErrorTest() throws Exception{

                mockMvc
                .perform(get("/products/followed/{userId}/list", 10)
                .param("order", "date_asc"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("T005 Validate Error")
    void postOkTest() throws Exception{

        mockMvc
                .perform(get("/products/post"))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed())
                .andReturn();
    }


    private void loadPosts()  {
        try{

            ObjectMapper mapper =
                    new ObjectMapper().registerModule(new JavaTimeModule())
                            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

            File jsonFile=null;
            jsonFile = ResourceUtils.getFile("classpath:post.json");
            this.postList = mapper.readValue(jsonFile, new TypeReference<List<Post>>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
