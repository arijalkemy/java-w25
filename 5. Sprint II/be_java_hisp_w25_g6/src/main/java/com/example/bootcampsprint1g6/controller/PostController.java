package com.example.bootcampsprint1g6.controller;

import com.example.bootcampsprint1g6.dto.PostListDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.service.IPostService;
import com.example.bootcampsprint1g6.service.implementation.PostServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class PostController {

    private IPostService postService;

    public PostController(PostServiceImpl postService){
        this.postService = postService;
    }

    /**
     * Enpoint to create a new post and save it
     * Posts can only be own by a seller
     * @param postRequestDTO json format containig the info of the new post
     * @return the post created
     */
    @PostMapping("/post")
    public ResponseEntity<PostResponseDTO> createPost(@Valid @RequestBody PostRequestDTO request) {
        return ResponseEntity.ok(postService.createPost(request));
    }

    /**
     * Enpoint to get all the posts created by the sellers the user follows
     * @param userId integer value of a user id
     * @param order and optional parameter to order posts in the result. Accepted values: date_asc or date_desc
     * @return the posts of the seller the user follows
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> getLastPostsByFollowed(
            @PathVariable Integer userId,
            @RequestParam(required = false, defaultValue = PostServiceImpl.DATE_DESC) String order
    ) {
        return ResponseEntity.ok(postService.getLastPostsByFollowed(userId, order));
    }

}
