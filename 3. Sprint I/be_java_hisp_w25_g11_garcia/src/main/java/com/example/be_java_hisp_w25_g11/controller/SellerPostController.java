package com.example.be_java_hisp_w25_g11.controller;

import com.example.be_java_hisp_w25_g11.dto.response.PromoPostCountDTO;
import com.example.be_java_hisp_w25_g11.dto.response.SellerPromoPostDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePostRequestDTO;
import com.example.be_java_hisp_w25_g11.dto.request.CreatePromoPostRequestDTO;
import com.example.be_java_hisp_w25_g11.dto.response.SellerPromoPostsListDTO;
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

    @PostMapping("/post")
    public ResponseEntity<?> postNewProduct(
            @RequestBody CreatePostRequestDTO request
    ) {
        return new ResponseEntity<>(sellerPostService.createPost(request), HttpStatus.OK);
    }

    // US 0010 - Publicación de un nuevo producto en promoción
    @PostMapping("/promo-post")
    public ResponseEntity<SellerPromoPostDTO> postNewPromoProduct(
            @RequestBody CreatePromoPostRequestDTO request
    ) {
        return new ResponseEntity<>(sellerPostService.createPromoPost(request), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPostsList(
            @PathVariable Integer userId,
            @RequestParam(required = false) String order
    ) {
        return new ResponseEntity<>(sellerPostService.getFollowedSellersLatestPosts(userId, order), HttpStatus.OK);
    }

    // US 0011 - Obtener la cantidad de productos en promoción de un determinado vendedor
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getPromoPostCount(
            @RequestParam Integer user_id
    ) {
        return new ResponseEntity<>(sellerPostService.getPromoPostCount(user_id), HttpStatus.OK);
    }

    // US 0012 - Obtener un listado de todos los productos en promoción de un determinado vendedor
    @GetMapping("/promo-post/list")
    public ResponseEntity<SellerPromoPostsListDTO> getPromoPostList(
            @RequestParam Integer user_id
    ) {
        return new ResponseEntity<>(sellerPostService.getPromoPostList(user_id), HttpStatus.OK);
    }
}