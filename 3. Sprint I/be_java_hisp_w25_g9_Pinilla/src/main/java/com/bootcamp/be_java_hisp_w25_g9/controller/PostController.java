package com.bootcamp.be_java_hisp_w25_g9.controller;

import com.bootcamp.be_java_hisp_w25_g9.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.MessageDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.SellerPromoPostsCountDto;
import com.bootcamp.be_java_hisp_w25_g9.exceptions.BadRequestException;
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
        if (newPost.has_promo() || newPost.discount() != 0)
            throw new BadRequestException("El post no debe tener promo o descuento");
        return new ResponseEntity<>(postService.createPost(newPost), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<MessageDto> insertNewPromoPost(@RequestBody PostRequestDto newPost){
        if (!newPost.has_promo() || newPost.discount() == 0)
            throw new BadRequestException("El post debe tener promo y descuento");
        return new ResponseEntity<>(postService.createPost(newPost), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SellerPromoPostsCountDto> getUserPromoPosts(@RequestParam(value = "user_id") int userId){
        return new ResponseEntity<>(postService.getSellerPromoPosts(userId), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPostOrderByDate(@PathVariable int userId, @RequestParam(value="order", required = false) String order){
        if(order == null) return new ResponseEntity<>(postService.getPost(userId), HttpStatus.OK);
        return new ResponseEntity<>(postService.getPost(userId, order),HttpStatus.OK);
    }


}
