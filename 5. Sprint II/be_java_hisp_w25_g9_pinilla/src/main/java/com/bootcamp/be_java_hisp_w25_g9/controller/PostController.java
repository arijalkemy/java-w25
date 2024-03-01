package com.bootcamp.be_java_hisp_w25_g9.controller;

import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowedPostsDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.MessageDto;
import com.bootcamp.be_java_hisp_w25_g9.service.interfaces.IPostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController{

    private final IPostService postService;

    public PostController(IPostService postService){
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<MessageDto> insertNewPost(@Valid @RequestBody PostRequestDto newPost){
        return new ResponseEntity<>(postService.createPost(newPost), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostsDto> getFollowedPostOrderByDate(@PathVariable int userId, @RequestParam(value="order", required = false) String order){
        if(order == null) return new ResponseEntity<>(postService.getPost(userId), HttpStatus.OK);
        return new ResponseEntity<>(postService.getPost(userId, order),HttpStatus.OK);
    }


}
