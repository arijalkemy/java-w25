package com.bootcamp.be_java_hisp_w25_g02.controller;
import com.bootcamp.be_java_hisp_w25_g02.dto.request.PromoPostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.PostDTO;
import com.bootcamp.be_java_hisp_w25_g02.service.IPostService;
import com.bootcamp.be_java_hisp_w25_g02.service.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> getFollowedPosts(@PathVariable Integer userId, @RequestParam(defaultValue = "date_asc", required = false) String order, @RequestParam(defaultValue = "false", required = false) Boolean promotion){
        return new ResponseEntity<>(this.postService.getPostsOrderedByDate(userId, order, promotion), HttpStatus.OK);
    }
    @PostMapping("/products/promo-post")
    public ResponseEntity<?> savePromoPost(@RequestBody PromoPostDTO promoPostDTO){
        return new ResponseEntity<>(this.postService.savePromoPost(promoPostDTO), HttpStatus.OK);
    }
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> getPromoCount(@RequestParam Integer user_id){
        return new ResponseEntity<>(this.postService.getPromoPostCount(user_id), HttpStatus.OK);
    }

    @PatchMapping("/products/promo-post/{post_id}/discount-change")
    public ResponseEntity<?> putDiscount(@PathVariable Integer post_id, @RequestParam Double discount){
        return new ResponseEntity<>(this.postService.updatePromotionDiscount(post_id,discount), HttpStatus.OK);
    }
    @PatchMapping("/products/promo-post/{post_id}/end-promotion")
    public ResponseEntity<?> patchEndPromotion(@PathVariable Integer post_id){
        return new ResponseEntity<>(this.postService.updateEndPromotion(post_id), HttpStatus.OK);
    }
}
