package com.bootcamp.be_java_hisp_w25_g14_Lozano.controller;

import com.bootcamp.be_java_hisp_w25_g14_Lozano.entity.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    private ObjectWriter objectWriter;

    List<Post> postList;

    public PostControllerTest(){
        this.objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        this.postList = new ArrayList<>();
    }

    @Test
    void promoListTest () throws Exception {
        List<Post> post = postList;

        String listPost = objectWriter.writeValueAsString(post);
        MvcResult listresult = mockMvc
                .perform(get("/products/promo-post/list"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();
                assertEquals(listPost,listresult.getResponse().getContentAsString());


    }





    private void loadPosts()  {
        try{
            ObjectMapper mapper = new ObjectMapper();
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
