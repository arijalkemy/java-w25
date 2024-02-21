package com.bootcamp.be_java_hisp_w25_g02.controller;
import com.bootcamp.be_java_hisp_w25_g02.dto.request.SavePromoDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.GenericResponseDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.PostDTO;
import com.bootcamp.be_java_hisp_w25_g02.entity.Post;
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
    public ResponseEntity<?> getFollowedPosts(@PathVariable Integer userId, @RequestParam(defaultValue = "date_asc", required = false) String order){
        return new ResponseEntity<>(this.postService.getPostsOrderedByDate(userId, order), HttpStatus.OK);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<?> savePromoPost(@RequestBody SavePromoDTO post){
        return new ResponseEntity<>(this.postService.savePromoPost(post), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> getPromoCount(@RequestParam Integer user_id){
        return new ResponseEntity<>(this.postService.getPromoCount(user_id), HttpStatus.OK);
    }

    @PatchMapping("products/promo-post/{post_id}/end-promotion")
    public ResponseEntity<?>pachEndPromotion(@PathVariable Integer post_id){
        GenericResponseDTO response = this.postService.endPromo(post_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
