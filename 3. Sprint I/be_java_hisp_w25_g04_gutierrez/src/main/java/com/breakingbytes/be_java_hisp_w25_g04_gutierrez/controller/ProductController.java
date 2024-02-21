package com.breakingbytes.be_java_hisp_w25_g04_gutierrez.controller;

import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.PostDTO;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response.PromoPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.exception.BadRequestException;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.service.ISellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ISellerService sellerService;
    public ProductController(ISellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> addPromoPost(@RequestBody PostDTO postDTO){
        //Agregué esta validación acá porque sino me quedaba igual que el endpoint /post . Debería sacarla?
        if (!postDTO.isHasPromo()) throw new BadRequestException("El post que quieres agregar tiene promo!");
        sellerService.addPost(postDTO);
        return ResponseEntity
                .ok().build();
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostDTO> getPromoCount(@RequestParam(name = "user_id") int userId){
        return ResponseEntity.ok()
                .body(sellerService.getPromoPostCount(userId));
    }
    @GetMapping("/promo-post/list")
    public ResponseEntity<List<PostDTO>> getPromoPosts(@RequestParam(name = "user_id") int userId){
        return ResponseEntity.ok()
                .body(sellerService.getPromoPosts(userId));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<LastPostsDTO> getPostOfVendorsFollowedByUser(
            @PathVariable int userId,
            @RequestParam(name = "order", required = false, defaultValue = "none") String order){
        return ResponseEntity.ok()
                .body(this.sellerService.getPostOfVendorsFollowedByUser(userId, order));
    }

    @PostMapping("/post")
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
}
