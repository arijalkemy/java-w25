package com.grupo08.socialmeli.utils;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.grupo08.socialmeli.dto.PostDto;
import com.grupo08.socialmeli.entity.Post;

public class PostMapper {
    public static Post fromDto(PostDto postDto){
        
        return new Post(
            postDto.getUserId(),
            postDto.getDate(),
            postDto.getProduct(),
            postDto.getCategory(),
            postDto.getPrice()
        );
    }

    public static PostDto toDto(Post post){
        PostDto postDto = new PostDto(
                post.getUserId(),
                post.getDate(),
                post.getProduct(),
                post.getCategory(),
                post.getPrice()
        );
        return postDto;
    }

    public static List<PostDto> ListToDto(List<Post> listPost){
        List<PostDto> listPostDto = new ArrayList<>();
        for (Post post: listPost){
            PostDto postDto = new PostDto(
                post.getUserId(), 
                post.getDate(), 
                post.getProduct(), 
                post.getCategory(), 
                post.getPrice()
            );
            listPostDto.add(postDto);
        }
        return listPostDto;
    }

}
