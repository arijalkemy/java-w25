package com.bootcamp.be_java_hisp_w25_g14.utils;

import com.bootcamp.be_java_hisp_w25_g14.dto.*;
import com.bootcamp.be_java_hisp_w25_g14.entity.Post;
import com.bootcamp.be_java_hisp_w25_g14.entity.Product;
import com.bootcamp.be_java_hisp_w25_g14.entity.User;

import java.util.List;

public class ApiMapper {

    public  static FollowedListResponseDto listSellersFollowers(User user,List<User> usersFollowers){
        FollowedListResponseDto followedDto = new FollowedListResponseDto();

        followedDto.setUser_id(user.getUserId());
        followedDto.setUser_name(user.getUserName());

        followedDto.setFollowers(usersFollowers.stream().map(user1 -> convertToUserDataDto(user1)).toList());



    return followedDto;

    }

    public static UserDataDto convertToUserDataDto(User user){

        return  new UserDataDto(user.getUserId(),user.getUserName());
    }



    public static PostDto convertToPostDto(Post post){

        PostDto postDto = new PostDto();
        postDto.setPost_id(post.getPostId());
        postDto.setUser_id(post.getUserId());
        postDto.setDate(post.getDate());
        postDto.setProduct(convertToProductDto(post.getProduct()));
        postDto.setCategory(post.getCategory());
        postDto.setPrice(post.getPrice());

        return postDto;

    }

    public static PostFullDto convertToPostFullDto(Post post){

        PostFullDto postFull = new PostFullDto();

        postFull.setPost_id(post.getPostId());
        postFull.setUser_id(post.getUserId());
        postFull.setDiscountUntil(post.getDiscountUntil());
        postFull.setIsOnDiscount(post.getIsOnDiscount());
        postFull.setDiscountPrice(post.getPrice());
        postFull.setDate(post.getDate());
        postFull.setProduct(convertToProductDto(post.getProduct()));
        postFull.setCategory(post.getCategory());
        postFull.setPrice(post.getPrice());

        return postFull;

    }

    public static Post convertToPostEntity(PostDto postDto){

        Post post = new Post();
        post.setIsOnDiscount(false);

        post.setUserId(postDto.getUser_id());
        post.setDate(postDto.getDate());
        post.setProduct(convertToProductEntity(postDto.getProduct()));
        post.setCategory(postDto.getCategory());
        post.setPrice(postDto.getPrice());

        return post;

    }


    public static Post convertToPostEntity(PostFullDto postFullDto){

        Post post = new Post();
        post.setUserId(postFullDto.getUser_id());
        post.setDate(postFullDto.getDate());
        post.setIsOnDiscount(postFullDto.getIsOnDiscount());
        post.setDiscountUntil(postFullDto.getDiscountUntil());
        post.setProduct(convertToProductEntity(postFullDto.getProduct()));
        post.setCategory(postFullDto.getCategory());
        post.setPrice(postFullDto.getPrice());
        post.setDiscountPrice(postFullDto.getDiscountPrice());

        return post;

    }



    public static ProductDto convertToProductDto(Product product){
        ProductDto productDto = new ProductDto();

        productDto.setProduct_id(product.getProductId());
        productDto.setProduct_name(product.getProductName());
        productDto.setType(product.getType());
        productDto.setBrand(product.getBrand());
        productDto.setColor(product.getColor());
        productDto.setNotes(product.getNotes());

        return productDto;

    }
    public static Product convertToProductEntity(ProductDto productDto){
        Product product = new Product();

        product.setProductId(productDto.getProduct_id());
        product.setProductName(productDto.getProduct_name());
        product.setType(productDto.getType());
        product.setBrand(productDto.getBrand());
        product.setColor(productDto.getColor());
        product.setNotes(productDto.getNotes());

        return product;

    }



}
