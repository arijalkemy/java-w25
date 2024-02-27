package com.example.be_java_hisp_w25_g11.controller;

import com.example.be_java_hisp_w25_g11.dto.product.ProductoPromoQuantityDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePostRequestDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePostRequestWithPromoDTO;
import com.example.be_java_hisp_w25_g11.service.seller_post.ISellerPostService;
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

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPostsList(
            @PathVariable Integer userId,
            @RequestParam(required = false) String order
    ) {
        return new ResponseEntity<>(sellerPostService.getFollowedSellersLatestPosts(userId, order), HttpStatus.OK);
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getQuantityPromoProducts(@RequestParam("user_id") Integer userId
                                                      ) {
        return new ResponseEntity<>(sellerPostService.getQuantityOfProductsWithPromo(userId), HttpStatus.OK);
    }@GetMapping("/promo-post/list")
    public ResponseEntity<?> getPromoProductsList(@RequestParam("user_id") Integer userId
                                                      ) {
        return new ResponseEntity<>(sellerPostService.getAllPromoProducts(userId), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postNewProduct(
            @RequestBody CreatePostRequestDTO request
    ) {
        return new ResponseEntity<>(sellerPostService.createPost(request), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromo(@RequestBody CreatePostRequestWithPromoDTO product) {
        return new ResponseEntity<>(sellerPostService.createPostWithPromo(product), HttpStatus.OK);
    }


}