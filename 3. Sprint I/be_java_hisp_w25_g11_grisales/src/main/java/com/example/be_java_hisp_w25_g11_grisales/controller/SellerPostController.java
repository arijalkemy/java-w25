package com.example.be_java_hisp_w25_g11_grisales.controller;

import com.example.be_java_hisp_w25_g11_grisales.dto.SellerPromoPostDTO;
import com.example.be_java_hisp_w25_g11_grisales.dto.request.CreatePostRequestDTO;
import com.example.be_java_hisp_w25_g11_grisales.dto.request.CreatePromoPostDTO;
import com.example.be_java_hisp_w25_g11_grisales.service.seller_post.ISellerPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class SellerPostController {
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
    public ResponseEntity<?> postNewPromoProduct(
            @RequestBody CreatePromoPostDTO request
            ) {
        return new ResponseEntity<>(sellerPostService.createNewPromoProduct(request), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> postCountPromoProduct(
        @RequestParam Integer user_id
    ) {
        return new ResponseEntity<>(sellerPostService.countPromoProducts(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getPromoProductsList(
            @RequestParam Integer user_id
            ) {
        return new ResponseEntity<>(sellerPostService.getSellerPromoProductList(user_id), HttpStatus.OK);
    }
}