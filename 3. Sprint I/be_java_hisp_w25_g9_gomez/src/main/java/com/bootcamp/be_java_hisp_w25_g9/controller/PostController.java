package com.bootcamp.be_java_hisp_w25_g9.controller;

import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.request.PromoPostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.MessageDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.PromoPostResponseDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.PromoProductsCountDto;
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
    public ResponseEntity<MessageDto> insertNewPromoPost(@RequestBody PromoPostRequestDto promoPostRequestDto){
        return new ResponseEntity<>(postService.createPromoPost(promoPostRequestDto),HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoProductsCountDto> getPromoProductsCountBySeller(@RequestParam int user_id){
        return new ResponseEntity<>(postService.getPromoProductsCountBySeller(user_id),HttpStatus.OK);
    }
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostResponseDto> getPromoPostBySeller(@RequestParam int user_id){
        return new ResponseEntity<>(postService.getPromoPostBySeller(user_id),HttpStatus.OK);
    }
    @GetMapping("/post/type")
    public ResponseEntity<?> getFollowedPostOrderByDate(@RequestParam String type,@RequestParam (value="promo", required = false)boolean promo){
        if(promo) return new ResponseEntity<>(postService.getPostByType(type,promo), HttpStatus.OK);
        return new ResponseEntity<>(postService.getPostByType(type), HttpStatus.OK);

    }


}
