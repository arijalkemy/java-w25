package com.example.be_java_hisp_w25_g10.utils;

import com.example.be_java_hisp_w25_g10.dtos.PostCreatedDto;
import com.example.be_java_hisp_w25_g10.entities.Post;
import com.example.be_java_hisp_w25_g10.entities.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PostMapper {
    public static Post fromDto(PostCreatedDto postDto, User user){
        Random random = new Random();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fecha = LocalDate.parse(postDto.date(), formatter);
        return new Post(
                random.nextInt(),
                user,

                fecha,
                postDto.product()
        );
    }
    public static PostCreatedDto toDto(Post post){
        return new PostCreatedDto(
                post.getUser().getId(),
                post.getDate().toString(),
                post.getProduct(),
                post.getProduct().getCategory(),
                post.getProduct().getPrice(),
                post.getProduct().getDiscount(),
                post.getProduct().getHasPromo()
        );
    }

    public static List<PostCreatedDto> ListToDto(List<Post> listPost){
        List<PostCreatedDto> listPostDto = new ArrayList<>();
        for (Post post: listPost){
            PostCreatedDto postDto = new PostCreatedDto(
                    post.getUser().getId(),
                    post.getDate().toString(),
                    post.getProduct(),
                    post.getProduct().getCategory(),
                    post.getProduct().getPrice(),
                    post.getProduct().getDiscount(),
                    post.getProduct().getHasPromo()
            );
            listPostDto.add(postDto);
        }
        return listPostDto;
    }
}

