package com.bootcamp.be_java_hisp_w25_g02.controller;
import com.bootcamp.be_java_hisp_w25_g02.dto.request.EndPromotionDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.PostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.PromotionAmountDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.PromotionListDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.PromotionPostDTO;
import com.bootcamp.be_java_hisp_w25_g02.service.IPostService;
import com.bootcamp.be_java_hisp_w25_g02.service.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {

    private final IPostService postService;
    public ProductController(PostServiceImpl postService){
        this.postService = postService;
    }
  
    @PostMapping("products/post")
    public ResponseEntity<?> savePost(@RequestBody PostDTO post) {
        return new ResponseEntity<>(this.postService.savePost(post), HttpStatus.OK);
    }

    @GetMapping("products/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPosts(@PathVariable Integer userId, @RequestParam(defaultValue = "date_asc", required = false) String order){
        return new ResponseEntity<>(this.postService.searchPostsOrderedByDate(userId, order), HttpStatus.OK);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<?> createNewPromotion(@RequestBody PromotionPostDTO newPromoDTO){
        PromotionPostDTO createdPromotion = this.postService.createNewPromo(newPromoDTO);
        return new ResponseEntity<>(createdPromotion, HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> getPromotionsAmount(@RequestParam(required = false) Integer user_id) {
        PromotionAmountDTO amount = postService.getPromotionsAmount(user_id);
        return new ResponseEntity<>(amount, HttpStatus.OK);
    }

    // US 12 (Opcional) - Obtener todas las promos de un determinado vendedor. Plus - ordenar por nombre.
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<?> getAllPromotions(
            @RequestParam(required = false) Integer user_id, @RequestParam(required = false) String order
    ) {
        PromotionListDTO promotions = postService.getPromotionsList(user_id);
        return new ResponseEntity<>(promotions, HttpStatus.OK);
    }

    // US 13 (Opcional) - Finalizar una promoción determinada
    @PatchMapping("/products/promo-post/end-promo")
    public ResponseEntity<?> endPromotion(@RequestBody EndPromotionDTO endPromoDTO){
        PromotionPostDTO ansPost =  postService.endPromotion(endPromoDTO);
        return new ResponseEntity<>(ansPost, HttpStatus.OK);
    }

    // @GetMapping("/products/getAllPosts")

    // @GetMapping("/products/getAllPromotions")

}
