package com.bootcamp.be_java_hisp_w25_g02.controller;
import com.bootcamp.be_java_hisp_w25_g02.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.PostRespDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.SellerPromoPostsDTO;
import com.bootcamp.be_java_hisp_w25_g02.service.IPostService;
import com.bootcamp.be_java_hisp_w25_g02.service.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<?> savePostWithDiscount(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.savePostWithDiscount(postDTO), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> getPromoPostsCountBySeller(@RequestParam Integer user_id) {
        return new ResponseEntity<>(postService.getPromoPostsCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/list")
    public ResponseEntity<SellerPromoPostsDTO> getPromoPostsBySeller(@RequestParam Integer user_id) {
        return new ResponseEntity<>(postService.getPromoPosts(user_id), HttpStatus.OK);
    }

    @GetMapping("/products/post")
    public ResponseEntity<List<PostRespDTO>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @DeleteMapping("/products/post/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Integer postId) {
        return new ResponseEntity<>(postService.deletePost(postId), HttpStatus.OK);
    }

    @PutMapping("/products/post/{postId}")
    public ResponseEntity<?> updatePost(@PathVariable Integer postId, @RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.updatePost(postId, postDTO), HttpStatus.OK);
    }
}
