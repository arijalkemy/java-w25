package com.grupo08.socialmeli.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.grupo08.socialmeli.dto.PostDto;
import com.grupo08.socialmeli.entity.Post;

public class PostMapper {
    public static Post fromDto(PostDto postDto){

        return new Post(
                postDto.getUserId(),
                LocalDate.parse(postDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                postDto.getProduct(),
                postDto.getCategory(),
                postDto.getPrice(),
                postDto.isHasPromo(),
                postDto.getDiscount()
        );
    }

    public static PostDto toDto(Post post){
        return new PostDto(
                post.getUserId(),
                post.getDate().toString(),
                post.getProduct(),
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount()
        );
    }

    public static List<PostDto> ListToDto(List<Post> listPost){
        List<PostDto> listPostDto = new ArrayList<>();
        for (Post post: listPost){
            PostDto postDto = new PostDto(
                    post.getUserId(),
                    post.getDate().toString(),
                    post.getProduct(),
                    post.getCategory(),
                    post.getPrice(),
                    post.isHasPromo(),
                    post.getDiscount()
            );
            listPostDto.add(postDto);
        }
        return listPostDto;
    }

}
