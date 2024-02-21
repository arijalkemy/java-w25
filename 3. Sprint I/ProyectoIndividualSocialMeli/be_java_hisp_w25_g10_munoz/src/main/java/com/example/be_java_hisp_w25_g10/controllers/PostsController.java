package com.example.be_java_hisp_w25_g10.controllers;

import com.example.be_java_hisp_w25_g10.dtos.DiscountedPostsCountDto;
import com.example.be_java_hisp_w25_g10.dtos.PostCreatedDto;
import com.example.be_java_hisp_w25_g10.dtos.PostsDto;
import com.example.be_java_hisp_w25_g10.exceptions.BadRequestException;
import com.example.be_java_hisp_w25_g10.services.posts.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/posts/discounted")
    public ResponseEntity<List<PostCreatedDto>> getDiscountedPosts() {
        return new ResponseEntity<>(postService.getDiscountedPosts(), HttpStatus.OK);
    }

    @GetMapping("/posts/discounted/count/{userId}")
    public ResponseEntity<DiscountedPostsCountDto> countDiscountedPosts(@PathVariable int userId) {
    return new ResponseEntity<>(postService.countDiscountedPosts(userId), HttpStatus.OK);
}
}
