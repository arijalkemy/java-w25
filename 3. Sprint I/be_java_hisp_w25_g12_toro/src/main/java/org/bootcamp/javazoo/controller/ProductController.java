package org.bootcamp.javazoo.controller;

import jakarta.validation.Valid;
import org.bootcamp.javazoo.dto.PostDto;
import org.bootcamp.javazoo.dto.response.CountPromoDto;
import org.bootcamp.javazoo.dto.response.MessageDto;
import org.bootcamp.javazoo.dto.response.PromoPostListDto;
import org.bootcamp.javazoo.exception.BadRequestException;
import org.bootcamp.javazoo.dto.response.PostsFollowedUserDto;
import org.bootcamp.javazoo.service.interfaces.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final IPostService postService;

    public ProductController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsFollowedUserDto> getPostsBySellerOfUser(@PathVariable Integer userId,
                                                                       @RequestParam(required = false) String order) {
        return ResponseEntity.ok(postService.getPostsBySellerOfUser(userId, order));
    }

    @PostMapping("/post")
    public ResponseEntity<?> addNewPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException("Invalid fields");
        }
        return new ResponseEntity<>(postService.addNewPost(postDto) , HttpStatus.CREATED);
    }
    @PostMapping("/promo-post")
    public ResponseEntity<MessageDto> addNewPromoPost(@Valid @RequestBody PostDto promoPostDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException("Invalid fields");
        }
        return ResponseEntity.status(HttpStatus.OK).body(postService.addNewPost(promoPostDto));
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<CountPromoDto> countPromoPosts(@RequestParam String user_id){
        return ResponseEntity.ok(postService.countPromoPosts(user_id));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostListDto> getPromoPostList(@RequestParam String user_id, @RequestParam(required = false) String order){
        return ResponseEntity.ok(postService.getPromoPostList(user_id, order));
    }
}
