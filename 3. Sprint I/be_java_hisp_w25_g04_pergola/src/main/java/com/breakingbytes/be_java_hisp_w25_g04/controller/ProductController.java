package com.breakingbytes.be_java_hisp_w25_g04.controller;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.service.ISellerService;
import com.breakingbytes.be_java_hisp_w25_g04.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    ISellerService sellerService;
    public ProductController(ISellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<LastPostsDTO> getPostOfVendorsFollowedByUser(
            @PathVariable int userId,
            @RequestParam(name = "order", required = false, defaultValue = "none") String order){
        return ResponseEntity.ok()
                .body(this.sellerService.getPostOfVendorsFollowedByUser(userId, order));
    }

    @PostMapping("/post")
    public ResponseEntity<?> addPost(@RequestBody RequestPostDTO requestPostDTO){
        sellerService.addPost(requestPostDTO);
        return ResponseEntity
                .ok().build();
    }

    @GetMapping("/posts")
    public ResponseEntity<?> getAllPosts(){
        return ResponseEntity.ok()
                .body(sellerService.findAllPosts());
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> addPromoPost(@RequestBody RequestPostDTO postDTO) {
        sellerService.addPost(postDTO);
        return ResponseEntity.ok()
                .build();
    }

    @GetMapping("/promo-post/list?user_id={userId}")
    public ResponseEntity<?> getPromoProducts(@PathVariable int userId) {
        return ResponseEntity.ok().body(sellerService.getPromoPost(userId));
    }
}
