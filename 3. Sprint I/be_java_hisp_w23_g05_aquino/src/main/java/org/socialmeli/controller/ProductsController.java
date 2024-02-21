package org.socialmeli.controller;

import org.socialmeli.dto.request.FollowedListReqDto;
import org.socialmeli.dto.request.PostReqDto;
import org.socialmeli.dto.request.PromoPostReqDto;
import org.socialmeli.dto.request.UserIdDto;
import org.socialmeli.dto.response.FollowedListDto;
import org.socialmeli.dto.response.PostIdDto;
import org.socialmeli.dto.response.PromoProductsCount;
import org.socialmeli.service.IPostsService;
import org.socialmeli.service.implementation.PostsServiceImp;
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

    // US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
    @PostMapping("/promo-post")
    public ResponseEntity<PostIdDto> createPromoPost(@RequestBody PromoPostReqDto postDto) {
        return new ResponseEntity<>(postsService.savePromoPost(postDto), HttpStatus.OK);
    }

    // US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoProductsCount> countPromoProducts(@RequestParam Integer user_id) {
        return new ResponseEntity<>(postsService.countPromoProductsFromVendor(new UserIdDto(user_id)) , HttpStatus.OK);
    }

}
