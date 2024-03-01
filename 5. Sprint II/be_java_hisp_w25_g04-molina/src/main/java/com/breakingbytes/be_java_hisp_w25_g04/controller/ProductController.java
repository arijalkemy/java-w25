package com.breakingbytes.be_java_hisp_w25_g04.controller;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.service.ISellerService;
import jakarta.validation.Valid;
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
            @PathVariable Integer userId,
            @RequestParam(name = "order", required = false, defaultValue = "") String order){
        return ResponseEntity.ok()
                .body(this.sellerService.getPostOfVendorsFollowedByUser(userId, order));
    }

    @PostMapping("/post")
    public ResponseEntity<?> addPost(@Valid @RequestBody RequestPostDTO requestPostDTO){
        sellerService.addPost(requestPostDTO);
        return ResponseEntity
                .ok().build();
    }

    @GetMapping("/posts")
    public ResponseEntity<?> getAllPosts(){
        return ResponseEntity.ok()
                .body(sellerService.findAllPosts());
    }
}
