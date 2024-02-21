package com.example.bootcampsprint1g6.controller;

import com.example.bootcampsprint1g6.dto.GenericResponseDTO;
import com.example.bootcampsprint1g6.dto.PostListDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.service.IPostService;
import com.example.bootcampsprint1g6.service.PostServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class PostController {

    private IPostService postService;

    public PostController(PostServiceImpl postService){
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<PostResponseDTO> createPost(@RequestBody PostRequestDTO request) {
        return ResponseEntity.ok(postService.createPost(request));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostResponseDTO> createPromoPost(@RequestBody PostRequestDTO request){
        return ResponseEntity.ok(postService.createPromoPost(request));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<List<PostResponseDTO>> getPromoPostByUser(@RequestParam(value= "user_id") Integer userId){

        return ResponseEntity.ok(postService.getPromoPost(userId));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<GenericResponseDTO> getQuantityPromoPostByUser(@RequestParam(value= "user_id") Integer userId){

        return ResponseEntity.ok(postService.getAumountPromoPost(userId));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> getLastPostsByFollowed(
            @PathVariable Integer userId,
            @RequestParam(required = false, defaultValue = PostServiceImpl.DATE_DESC) String order
    ) {
        return ResponseEntity.ok(postService.getLastPostsByFollowed(userId, order));
    }

}
