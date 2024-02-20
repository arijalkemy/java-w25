package com.example.be_java_hisp_w25_g01.controller;

import com.example.be_java_hisp_w25_g01.dto.request.PostDTO;
import com.example.be_java_hisp_w25_g01.dto.request.PostWithoutDiscountDTO;
import com.example.be_java_hisp_w25_g01.dto.response.DiscountPostsDTO;
import com.example.be_java_hisp_w25_g01.dto.response.MessagesDTO;
import com.example.be_java_hisp_w25_g01.dto.response.PostsListDTO;
import com.example.be_java_hisp_w25_g01.service.IPostService;
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
    public ResponseEntity<?> postProduct(@RequestBody PostWithoutDiscountDTO post){
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

    @PostMapping("/promo-post")
    public ResponseEntity<?> addPromoPost(@RequestBody PostDTO post){
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<DiscountPostsDTO> discountCounter(@RequestParam Integer userId){
        return ResponseEntity.status(HttpStatus.OK).body(postService.getCountOfDiscountById(userId));
    }
}
