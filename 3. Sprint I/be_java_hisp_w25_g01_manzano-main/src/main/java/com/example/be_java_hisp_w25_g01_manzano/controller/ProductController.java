package com.example.be_java_hisp_w25_g01_manzano.controller;

import com.example.be_java_hisp_w25_g01_manzano.dto.request.PostDTO;
import com.example.be_java_hisp_w25_g01_manzano.dto.request.PromoPostDTO;
import com.example.be_java_hisp_w25_g01_manzano.dto.response.PostsListDTO;
import com.example.be_java_hisp_w25_g01_manzano.dto.response.PromoPostCountDTO;
import com.example.be_java_hisp_w25_g01_manzano.dto.response.PromoPostsListDTO;
import com.example.be_java_hisp_w25_g01_manzano.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IPostService postService;


    @PostMapping("/post")
    public ResponseEntity<?> postPost(@RequestBody PostDTO post){
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
    }

    //US 0006 & US 0009
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsListDTO> listPosts(@PathVariable Integer userId,
                                                  @RequestParam(required = false) String order){
        PostsListDTO posts = postService.getLastPostsFollowedBy(userId);
        if ("date_asc".equalsIgnoreCase(order)) {
            posts.setPostsList(posts.getPostsList().stream().sorted(Comparator.comparing(PostDTO::getDate)).toList());
        } else if ("date_desc".equalsIgnoreCase(order)) {
            posts.setPostsList(posts.getPostsList().stream().sorted(Comparator.comparing(PostDTO::getDate).reversed()).toList());
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    //US10
    @PostMapping("/promo-post")
    public ResponseEntity<?> postPromoPost(@RequestBody PromoPostDTO post){
        return new ResponseEntity<>(postService.createPromoPost(post), HttpStatus.OK);
    }

    //US11
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getPromoPostCount(@RequestParam Integer user_id){
        return new ResponseEntity<>(postService.getPromoPostCount(user_id), HttpStatus.OK);
    }

    //US12 Bonus
    @GetMapping("/followed/{userId}/sale-list")
    public ResponseEntity<PromoPostsListDTO> listSalePosts(@PathVariable Integer userId,
                                                  @RequestParam(required = false) String order){
        return new ResponseEntity<>(postService.getSalePostsFollowedBy(userId, order), HttpStatus.OK);
    }

}
