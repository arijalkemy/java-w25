package com.breakingbytes.be_java_hisp_w25_g04.controller;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPromoPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ListPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.service.ISellerService;
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
    public ResponseEntity<ListPostsDTO> getPostOfVendorsFollowedByUser(
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

    @PostMapping("/promo-post")
    public ResponseEntity<?> addPromoPost(@RequestBody RequestPromoPostDTO requestPromoPostDTO){
        sellerService.addPromoPost(requestPromoPostDTO);
        return ResponseEntity
                .ok().build();
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> countPromoPosts(@RequestParam("user_id") int user_id){
        return ResponseEntity.ok()
                .body(sellerService.countPromoPosts(user_id));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> listPromoPost(
            @RequestParam("user_id") int user_id,
            @RequestParam(name = "order", required = false, defaultValue = "none") String order){
        return ResponseEntity.ok()
                .body(sellerService.listPromoPosts(user_id, order));
    }

    @GetMapping("/posts")
    public ResponseEntity<?> getAllPosts(){
        return ResponseEntity.ok()
                .body(sellerService.findAllPosts());
    }
}
