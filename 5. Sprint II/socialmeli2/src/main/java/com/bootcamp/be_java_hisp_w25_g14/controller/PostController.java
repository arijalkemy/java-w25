package com.bootcamp.be_java_hisp_w25_g14.controller;

import com.bootcamp.be_java_hisp_w25_g14.dto.PostDto;
import com.bootcamp.be_java_hisp_w25_g14.service.IPostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bootcamp.be_java_hisp_w25_g14.utils.UserValidator.validateUserId;


@RestController
@RequestMapping("/products")
public class PostController {

    private IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/getAllPosts")
    public ResponseEntity<?> findAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPostsLastTwoWeeks(@PathVariable Integer userId, @RequestParam(required = false) String order){
        validateUserId(userId, "UserId");
        return new ResponseEntity<>(postService.getFollowedPostsByUserLastTwoWeeks(userId,order),HttpStatus.OK);
    }


    @PostMapping("/post")
    public ResponseEntity<?> savePost(@Valid @RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.savePost(postDto), HttpStatus.OK);
    }


}
