package com.breakingbytes.be_java_hisp_w25_g04.controller;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.PostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PostDto;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PromoPostCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.PromoPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.service.ISellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SellerController {

    ISellerService sellerService;
    public SellerController(ISellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return ResponseEntity.ok()
                .body(sellerService.findAllPosts());
    }


    @PostMapping("/products/post")
    public ResponseEntity<?> addPost(@RequestBody PostDTO postDTO){
        sellerService.addPost(postDTO);
        return ResponseEntity
                .ok().build();
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<?> addPromoPost(@RequestBody PostDTO postDTO){
        sellerService.addPost(postDTO);
        return ResponseEntity
                .ok().build();
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getCountOfDiscountProduct(@RequestParam("user_id") int userId){
        return ResponseEntity.ok().body(sellerService.countProducsInDiscount(userId));
    }

    @GetMapping("/products/promo-post/list")
    public ResponseEntity<PromoPostDTO> getPostsWithDiscount(@RequestParam("user_id") int userId){
        return ResponseEntity.ok().body(sellerService.findPostsWithDiscountByIdSeller(userId));
    }
}
