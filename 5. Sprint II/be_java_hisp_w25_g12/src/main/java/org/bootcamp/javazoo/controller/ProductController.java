package org.bootcamp.javazoo.controller;

import jakarta.validation.Valid;
import org.bootcamp.javazoo.dto.PostDto;
import org.bootcamp.javazoo.exception.BadRequestException;
import org.bootcamp.javazoo.dto.response.PostsFollowedUserDto;
import org.bootcamp.javazoo.service.interfaces.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final IPostService postService;

    public ProductController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsFollowedUserDto> getPostsBySellerOfUser(@PathVariable Integer userId,
                                                                       @RequestParam(required = false) String order) {
        return ResponseEntity.ok(postService.getPostsBySellerOfUser(userId, order));
    }

    @PostMapping("/post")
    public ResponseEntity<?> addNewPost(@Valid @RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.addNewPost(postDto) , HttpStatus.CREATED);
    }
}
