package com.example.be_java_hisp_w25_g10.controllers;
import com.example.be_java_hisp_w25_g10.dtos.DiscountedProductsDto;
import com.example.be_java_hisp_w25_g10.dtos.PostCreatedDto;
import com.example.be_java_hisp_w25_g10.dtos.PostsDto;
import com.example.be_java_hisp_w25_g10.dtos.ProductDto;
import com.example.be_java_hisp_w25_g10.exceptions.BadRequestException;
import com.example.be_java_hisp_w25_g10.services.posts.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class PostsController {
    @Autowired
    IPostService postService;

    @PostMapping("/products/post")
    public ResponseEntity<PostCreatedDto> addPost(@RequestBody PostCreatedDto newPost){

        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate.parse(newPost.date(), formatter);

        }catch(RuntimeException e){
            throw new BadRequestException("Ingresar una fecha valida");
        }


        return new ResponseEntity<>(postService.createPost(newPost), HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostCreatedDto>> getPosts() {
        return new ResponseEntity<>(postService.verPosts(), HttpStatus.CREATED);
    }

    @GetMapping("products/followed/{userId}/list")
    ResponseEntity<PostsDto> getPostsFollowed(@PathVariable int userId, @RequestParam(required = false) String sortOrder){
        return new ResponseEntity<>(postService.getPostsFollowed(userId, sortOrder), HttpStatus.OK);
    }

    @GetMapping("/products/seller/{userId}/discounts")
    public ResponseEntity<DiscountedProductsDto> getUserDiscountedoProducts(@PathVariable int userId) {
        return ResponseEntity.ok()
        .body(
            new DiscountedProductsDto(postService.getSellerDiscountedProducts(userId))
        );
    }
    

}
