package com.grupo08.socialmeli.utils;

import java.util.ArrayList;
import java.util.List;

import com.grupo08.socialmeli.dto.PostDto;
import com.grupo08.socialmeli.dto.PostPromoDto;
import com.grupo08.socialmeli.entity.Post;

public class PostMapper {
    public static Post fromDto(PostDto postDto){
        
        return new Post(
            postDto.getUserId(),
            postDto.getDate(),
            postDto.getProduct(),
            postDto.getCategory(),
            postDto.getPrice(),
            false,
            0.0
        );
    }

    public static Post fromPostPromoDto(PostPromoDto postPromoDto){
        
        return new Post(
            postPromoDto.getUserId(),
            postPromoDto.getDate(),
            postPromoDto.getProduct(),
            postPromoDto.getCategory(),
            postPromoDto.getPrice(),
            postPromoDto.isHas_promo(),
            postPromoDto.getDiscount()
        );
    }

    public static PostDto toDto(Post post){
        return new PostDto(
            post.getUserId(),
            post.getDate().toString(),
            post.getProduct(),
            post.getCategory(),
            post.getPrice()
        );
    }

    public static PostPromoDto toPostPromoDto(Post post){
        return new PostPromoDto(
            post.getUserId(),
            post.getDate().toString(),
            post.getProduct(),
            post.getCategory(),
            post.getPrice(),
            post.isHas_promo(),
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
                post.getPrice()
            );
            listPostDto.add(postDto);
        }
        return listPostDto;
    }

    public static List<PostPromoDto> ListToPostPromoDto(List<Post> listPost){
        List<PostPromoDto> listPostPromoDto = new ArrayList<>();
        for (Post post: listPost){
            PostPromoDto postPromoDto = new PostPromoDto(
                post.getUserId(), 
                post.getDate().toString(), 
                post.getProduct(), 
                post.getCategory(), 
                post.getPrice(),
                post.isHas_promo(),
                post.getDiscount()
            );
            listPostPromoDto.add(postPromoDto);
        }
        return listPostPromoDto;
    }

}
