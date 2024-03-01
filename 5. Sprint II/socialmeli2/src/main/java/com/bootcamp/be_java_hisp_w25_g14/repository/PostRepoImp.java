package com.bootcamp.be_java_hisp_w25_g14.repository;

import com.bootcamp.be_java_hisp_w25_g14.entity.Post;
import com.bootcamp.be_java_hisp_w25_g14.entity.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PostRepoImp implements IPostRepo{

    List<Post> postList;

    int countId;

    public PostRepoImp(List<Product> postList) {
        this.postList = new ArrayList<>();
        this.countId = 4;
        loadPosts();
    }

    @Override
    public void savePost(Post post) {
        post.setPostId(this.getCountId());
        this.postList.add(post);

        this.setCountId(getCountId()+1);
    }

    @Override
    public List<Post> getPostsById(Integer id) {
        return this.postList.stream().filter(post -> post.getUserId().equals(id)).toList();
    }

    @Override
    public List<Post> getAllPosts() {
        return postList;
    }

    public int getCountId() {
        return countId;
    }

    public void setCountId(int count) {
        this.countId = count;
    }

    private void loadPosts()  {
        try{
            /*ObjectMapper mapper = new ObjectMapper();
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.registerModule(new JavaTimeModule());*/

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
