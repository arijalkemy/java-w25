package org.socialmeli.controller;

import org.socialmeli.dto.request.FollowedListReqDto;
import org.socialmeli.dto.request.post.PostReqDto;
import org.socialmeli.dto.request.post.PromoPostReqDto;
import org.socialmeli.dto.response.FollowedListDto;
import org.socialmeli.dto.response.post.PostIdDto;
import org.socialmeli.dto.response.post.PromoPostCountDto;
import org.socialmeli.service.IPostsService;
import org.socialmeli.service.PostsServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private IPostsService postsService;

    public ProductsController(PostsServiceImp postsService) {
        this.postsService = postsService;
    }

    // US_0005
    @PostMapping("/post")
    public ResponseEntity<PostIdDto> createPost(@RequestBody PostReqDto postDto) {
        return new ResponseEntity<>(postsService.savePost(postDto), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostIdDto> createPromoPost(
            @RequestBody PromoPostReqDto promoPostReqDto
    ) {
        return new ResponseEntity<>(postsService.savePost(promoPostReqDto), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDto> countPromoPosts(
            @RequestParam Integer user_id
    ) {
        return new ResponseEntity<>(postsService.countPromoPosts(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostCountDto> listVendorPromos(
            @RequestParam Integer user_id
    ) {
        return new ResponseEntity<>(postsService.countPromoPosts(user_id), HttpStatus.OK);
    }

    // US_0006 & US_0009
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedListDto> followedList(
            @PathVariable Integer userId,
            @RequestParam(required = false, defaultValue = "date_desc") String order) {
        return new ResponseEntity<>(postsService.getFollowedList(new FollowedListReqDto(userId, order)), HttpStatus.OK);
    }
}
