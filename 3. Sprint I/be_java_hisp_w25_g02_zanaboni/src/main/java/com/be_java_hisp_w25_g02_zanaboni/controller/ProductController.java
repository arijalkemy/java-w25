package com.be_java_hisp_w25_g02_zanaboni.controller;

import com.be_java_hisp_w25_g02_zanaboni.dto.response.PostDTO;
import com.be_java_hisp_w25_g02_zanaboni.service.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private final PostServiceImpl postService;
    public ProductController(PostServiceImpl postService){
        this.postService = postService;
    }

    @PostMapping("/products/post")
    public ResponseEntity<?> savePost(@RequestBody PostDTO post) {
        return new ResponseEntity<>(this.postService.savePost(post), HttpStatus.OK);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<?> savePromoPost(@RequestBody PostDTO post) {
        return new ResponseEntity<>(this.postService.savePost(post), HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPosts(@PathVariable Integer userId, @RequestParam(defaultValue = "date_asc", required = false) String order){
        return new ResponseEntity<>(this.postService.searchPostsOrderedByDate(userId, order), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> searchPostsOnSale(@RequestParam("user_id") Integer userId){
        return new ResponseEntity<>(this.postService.searchPostsOnSaleById(userId), HttpStatus.OK);
    }
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<?> getAllPostsOnSaleById(@RequestParam("user_id") Integer userId){
        return new ResponseEntity<>(this.postService.getAllPostsOnSaleById(userId), HttpStatus.OK);
    }
}
