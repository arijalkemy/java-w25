package com.example.be_java_hisp_w25_g10.controllers;

import com.example.be_java_hisp_w25_g10.dtos.*;
import com.example.be_java_hisp_w25_g10.dtos.promos.PromoDto;
import com.example.be_java_hisp_w25_g10.dtos.promos.SummaryPromotionsDto;
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

    @PostMapping("products/promo-post")
    public ResponseEntity<PromoDto> createPromotion(@RequestBody PromoDto dto){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate.parse(dto.date(), formatter);
        }catch(RuntimeException e){
            throw new BadRequestException("Ingresar una fecha valida");
        }

        return new ResponseEntity<>(this.postService.createPromo(dto), HttpStatus.OK);
    }

    @GetMapping("products/promo-post/count")
    public ResponseEntity<SummaryPromotionsDto> getCountPromotionsBySeller(@RequestParam int user_id){
        return new ResponseEntity<>(this.postService.getSummaryPromotions(user_id), HttpStatus.OK);
    }

}
