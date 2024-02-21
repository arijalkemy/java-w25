package com.breakingbytes.be_java_hisp_w25_g04.controller;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.PostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.service.IPostService;
import com.breakingbytes.be_java_hisp_w25_g04.service.PostServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    IPostService postService;

    public PostController (PostServiceImpl postService){
        this.postService = postService;
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<LastPostsDTO> getPostOfVendorsFollowedByUser(
            @PathVariable int userId,
            @RequestParam(name = "order", required = false, defaultValue = "none") String order){
        return ResponseEntity.ok().body(this.postService.getPostOfVendorsFollowedByUser(userId, order));
    }

    @PostMapping("/products/post")
    public ResponseEntity<?> addPost(@RequestBody PostDTO postDTO){
        postService.addPost(postDTO);
        return ResponseEntity
                .ok().build();
    }

    // Ejercicio 0010
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> getPostsWithPromotion(@RequestBody PostDTO postDTO) {
        postService.addPostWithPromotion(postDTO);
        return ResponseEntity.ok().build();
    }

    // Ejercicio 0011
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> getAmountOfPromoPosts(@RequestParam(required = false) int user_id) {
        return ResponseEntity.ok(postService.getAmountPromoPost(user_id));
    }

    // Ejercicio 0012
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<?> getPromoPostByUser(@RequestParam(required = false) int user_id) {
        return ResponseEntity.ok(postService.getPromoPostsByUser(user_id));
    }

    /*
    @GetMapping("/posts")
    public ResponseEntity<?> getAllPosts(){
        return ResponseEntity.ok()
                .body(postService.findAllPosts());
    }
     */
}
