package com.example.be_java_hisp_w25_g11.controller;

import com.example.be_java_hisp_w25_g11.dto.request.CreatePostRequestDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePromoPostRequestDTO;
import com.example.be_java_hisp_w25_g11.entity.SellerPost;
import com.example.be_java_hisp_w25_g11.service.seller_post.ISellerPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class    SellerPostController {
    private final ISellerPostService sellerPostService;

    public SellerPostController(
            ISellerPostService sellerPostService
    ) {
        this.sellerPostService = sellerPostService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> postNewProduct(
            @RequestBody CreatePostRequestDTO request
    ) {
        return new ResponseEntity<>(sellerPostService.createPost(request), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPostsList(
            @PathVariable Integer userId,
            @RequestParam(required = false) String order
    ) {
        return new ResponseEntity<>(sellerPostService.getFollowedSellersLatestPosts(userId, order), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?>postNewPromoProduct(
            @RequestBody CreatePromoPostRequestDTO request
    ){
        return new ResponseEntity<>(sellerPostService.createPromoPost(request), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getSellerPromoPostCount(
            @RequestParam Integer user_id
    ) {
        return new ResponseEntity<>(sellerPostService.getSellerPromoPostCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getSellerPromoPostList(
            @RequestParam Integer user_id
    ) {
        return new ResponseEntity<>(sellerPostService.getSellerPromoPostList(user_id), HttpStatus.OK);
    }
}