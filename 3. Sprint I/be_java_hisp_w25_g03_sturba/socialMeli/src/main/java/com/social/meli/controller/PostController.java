package com.social.meli.controller;

import com.social.meli.dto.request.PromoPostDto;
import com.social.meli.dto.response.*;
import com.social.meli.dto.request.PostDTO;
import com.social.meli.service.IPostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class PostController {

    private final IPostService postService;


    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PublicationDto> obtainLastPublicationsByTheFollowedVendors(
            @PathVariable Integer userId,
            @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(postService.obtainLastPublicationsByTheFollowedVendors(userId, order));
    }

    @PostMapping("/post")
    public ResponseEntity<MessageDTO> addNewPost(@RequestBody PostDTO postDto) {
        postService.addPost(postDto);
        return new ResponseEntity<>(new MessageDTO("Post creado con éxito"), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<MessageDTO> addNewPromoPost(@RequestBody PromoPostDto promoPostDto) {
        postService.addPromoPost(promoPostDto);
        return new ResponseEntity<>(new MessageDTO("Post con promo creado con éxito"), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<VendorPromoProductCountDto> getPromoProductsCountByUserId(@RequestParam(name = "user_id") Integer userId) {
        return new ResponseEntity<>(postService.getVendorPromoProductCount(userId), HttpStatus.OK);
    }
    @GetMapping("/promo-post/list")
    public ResponseEntity<VendorPromoProductListDto> getPromoProductsListByUserId(@RequestParam(name = "user_id") Integer userId) {
        return new ResponseEntity<>(postService.getVendorPromoProductList(userId), HttpStatus.OK);
    }

}
