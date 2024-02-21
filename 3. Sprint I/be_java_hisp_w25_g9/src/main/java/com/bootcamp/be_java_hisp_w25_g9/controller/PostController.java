package com.bootcamp.be_java_hisp_w25_g9.controller;

import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.service.interfaces.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController{

    public IPostService postService;

    public PostController(IPostService postService){
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> insertNewPost(@RequestBody PostRequestDto newPost){
        return new ResponseEntity<>(postService.createPost(newPost), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPostOrderByDate(@PathVariable int userId, @RequestParam(value="order", required = false) String order){
        if(order == null) return new ResponseEntity<>(postService.getPost(userId), HttpStatus.OK);
        return new ResponseEntity<>(postService.getPost(userId, order),HttpStatus.OK);
    }


}
