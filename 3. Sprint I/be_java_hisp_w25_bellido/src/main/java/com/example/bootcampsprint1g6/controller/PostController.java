package com.example.bootcampsprint1g6.controller;

import com.example.bootcampsprint1g6.dto.PostListDTO;
import com.example.bootcampsprint1g6.dto.PostPromoListDTO;
import com.example.bootcampsprint1g6.dto.PromoCountDTO;
import com.example.bootcampsprint1g6.dto.request.PostPromoRequestDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostPromoResponseDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.service.IPostService;
import com.example.bootcampsprint1g6.service.implementation.PostServiceImpl;
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

    @PostMapping("/promo-post")
    public ResponseEntity<PostPromoResponseDTO> createPostPromo(@RequestBody PostPromoRequestDTO request){
        return ResponseEntity.ok(postService.createPostPromo(request));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> getLastPostsByFollowed(
            @PathVariable Integer userId,
            @RequestParam(required = false, defaultValue = PostServiceImpl.DATE_DESC) String order
    ) {
        return ResponseEntity.ok(postService.getLastPostsByFollowed(userId, order));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoCountDTO> countPromosById(@RequestParam Integer user_id) {

        return ResponseEntity.ok(postService.countPromosById(user_id));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PostPromoListDTO> listPromosByUserId(@RequestParam Integer user_id) {

        return ResponseEntity.ok(postService.listPromosByUserId(user_id));
    }
}
