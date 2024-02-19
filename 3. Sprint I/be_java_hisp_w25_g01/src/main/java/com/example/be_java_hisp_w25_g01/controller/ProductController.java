package com.example.be_java_hisp_w25_g01.controller;

import com.example.be_java_hisp_w25_g01.dto.request.PostDTO;
import com.example.be_java_hisp_w25_g01.dto.response.PostsListDTO;
import com.example.be_java_hisp_w25_g01.dto.response.UserDTO;
import com.example.be_java_hisp_w25_g01.entity.Post;
import com.example.be_java_hisp_w25_g01.entity.Product;
import com.example.be_java_hisp_w25_g01.service.IPostService;
import com.example.be_java_hisp_w25_g01.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IPostService postService;


    @PostMapping("/post")
    public ResponseEntity<?> postProduct(@RequestBody PostDTO post){
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

}
