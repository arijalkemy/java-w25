package com.breakingbytes.be_java_hisp_w25_g04.controller;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.PostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.service.ISellerService;
import com.breakingbytes.be_java_hisp_w25_g04.service.SellerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SellerController {

    ISellerService sellerService;

    public SellerController(SellerServiceImpl sellerService){
        this.sellerService = sellerService;
    }

    @PostMapping("/products/post")
    public ResponseEntity<?> addPost(@RequestBody PostDTO postDTO){
        sellerService.addPost(postDTO);
        return ResponseEntity
                .ok().build();
    }

    @GetMapping("/posts")
    public ResponseEntity<?> getAllPosts(){
        return ResponseEntity.ok()
                .body(sellerService.findAllPosts());
    }

    // Ejercicio 0010
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> getPostsWithPromotion(@RequestBody PostDTO postDTO) {
        sellerService.addPostWithPromotion(postDTO);
        return ResponseEntity.ok().build();
    }

    // Ejercicio 0011
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> getAmountOfPromoPosts(@RequestParam(required = false) int user_id) {
        return ResponseEntity.ok(sellerService.getAmountPromoPost(user_id));
    }

    // Ejercicio 0012
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<?> getPromoPostByUser(@RequestParam(required = false) int user_id) {
        return ResponseEntity.ok(sellerService.getPromoPostsByUser(user_id));
    }
}
