package com.example.bootcampsprint1g6.controller;

import com.example.bootcampsprint1g6.dto.PostListDTO;
import com.example.bootcampsprint1g6.dto.request.PostPromoRequestDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostPromoCountResponse;
import com.example.bootcampsprint1g6.dto.response.PostPromoListResponse;
import com.example.bootcampsprint1g6.dto.response.PostPromoResponseDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.service.IPostService;
import com.example.bootcampsprint1g6.service.PostServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> getLastPostsByFollowed(
            @PathVariable Integer userId,
            @RequestParam(required = false, defaultValue = PostServiceImpl.DATE_DESC) String order
    ) {
        return ResponseEntity.ok(postService.getLastPostsByFollowed(userId, order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostPromoResponseDTO> createPostPromo(@RequestBody PostPromoRequestDTO request) {
        return ResponseEntity.ok(postService.createPostPromo(request));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PostPromoCountResponse> getAmountOfPostPromoOfSeller(@RequestParam(value = "user_id") Integer userId) {
        return ResponseEntity.ok(postService.getAmountOfPostPromoOfSeller(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PostPromoListResponse> getListOfPostPromoOfSeller(@RequestParam(value = "user_id") Integer userId) {
        return ResponseEntity.ok(postService.getListOfPostPromoOfSeller(userId));
    }

}
