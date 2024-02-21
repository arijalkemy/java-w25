package org.socialmeli.controller;

import org.socialmeli.dto.request.FollowedListReqDto;
import org.socialmeli.dto.request.PostDiscountReqDto;
import org.socialmeli.dto.request.PostReqDto;
import org.socialmeli.dto.request.UserIdDto;
import org.socialmeli.dto.response.DiscountCountDto;
import org.socialmeli.dto.response.FollowedListDto;
import org.socialmeli.dto.response.PostIdDto;
import org.socialmeli.dto.response.PromoListResDto;
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

    // US_0006 & US_0009
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedListDto> followedList(
            @PathVariable Integer userId,
            @RequestParam(required = false, defaultValue = "date_desc") String order) {
        return new ResponseEntity<>(postsService.getFollowedList(new FollowedListReqDto(userId, order)), HttpStatus.OK);
    }

    // US_0010
    @PostMapping("/promo-post")
    public ResponseEntity<PostIdDto> createPostDiscount(@RequestBody PostDiscountReqDto postDiscountReqDto) {
        return new ResponseEntity<>(postsService.savePostDiscount(postDiscountReqDto), HttpStatus.OK);
    }

    // US_0011
    @GetMapping("/promo-post/count")
    public ResponseEntity<DiscountCountDto> vendorProductsDiscountCount(@RequestParam Integer user_id) {
        return new ResponseEntity<>(postsService.vendorProductsDiscountCount(new UserIdDto(user_id)), HttpStatus.OK);
    }

    // US_0012
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoListResDto> vendorProductsDiscountList(@RequestParam Integer user_id) {
        return new ResponseEntity<>(postsService.vendorProductsDiscountList(new UserIdDto(user_id)), HttpStatus.OK);
    }
}
