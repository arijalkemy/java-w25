package com.bootcamp.be_java_hisp_w25_g9.controller;

import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PromoPostDto;
import com.bootcamp.be_java_hisp_w25_g9.service.interfaces.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController{

    public IPostService postService;

    public PostController(IPostService postService){
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> insertNewPost(@RequestBody PostRequestDto newPost){
        return new ResponseEntity<>(postService.createPost(newPost), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPostOrderByDate(@PathVariable int userId, @RequestParam(value="order", required = false) String order){
        if(order == null) return new ResponseEntity<>(postService.getPost(userId), HttpStatus.OK);
        return new ResponseEntity<>(postService.getPost(userId, order),HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> insertNewPromoPost(@RequestBody PromoPostDto promoPost){
        return new ResponseEntity<>(postService.createPromoPost(promoPost), HttpStatus.OK);
    }

    @GetMapping("promo-post/count")
    public ResponseEntity<?> getPromoPostCount(@RequestParam(value="user_id") int userId){
        return new ResponseEntity<>(postService.getCountPromoPost(userId), HttpStatus.OK);
    }


}
