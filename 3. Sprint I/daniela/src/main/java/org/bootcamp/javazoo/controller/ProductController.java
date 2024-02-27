package org.bootcamp.javazoo.controller;

import org.bootcamp.javazoo.dto.MessageDTO;
import org.bootcamp.javazoo.dto.PostDto;
import org.bootcamp.javazoo.dto.PostPromoDto;
import org.bootcamp.javazoo.dto.response.CountFollowersDto;
import org.bootcamp.javazoo.dto.response.PostsFollowedUserDto;
import org.bootcamp.javazoo.dto.response.PromoProductsCountDto;
import org.bootcamp.javazoo.service.interfaces.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final IPostService postService;
    private final IPostService postPromoService;

    public ProductController(IPostService postService, IPostService postPromoService) {
        this.postService = postService;
        this.postPromoService = postPromoService;
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsFollowedUserDto> getPostsBySellerOfUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(postService.getPostsBySellerOfUser(userId));
    }

    @PostMapping("/post")
    public ResponseEntity<?> addNewPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.addNewPost(postDto) , HttpStatus.CREATED);
    }
    @PostMapping("/promo-post")
    public ResponseEntity<?> addNewPostPromo(@RequestBody PostPromoDto postPromoDto) {
        ResponseEntity<MessageDTO> response = postPromoService.addNewPostPromo(postPromoDto);
        if (response.getStatusCode() == HttpStatus.CREATED) {
            return ResponseEntity.ok(response.getBody());
        } else if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            return ResponseEntity.badRequest().body(response.getBody());
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoProductsCount(@RequestParam("user_id") Integer userId) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPostPromo(userId));
    }
}
