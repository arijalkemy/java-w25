package com.socialMeli.controller;

import com.socialMeli.dto.request.PostDTO;

import com.socialMeli.dto.response.MessageDto;
import com.socialMeli.dto.response.PublicationDto;

import com.socialMeli.dto.response.*;

import com.socialMeli.service.IPostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PostController {

    private final IPostService postService;

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PublicationDto> obtainLastPublicationsByTheFollowedVendors(
                                                            @PathVariable Integer userId,
                                                            @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(postService
                .obtainLastPublicationsByTheFollowedVendors(userId, order));
    }

    @PostMapping("/products/post")
    public ResponseEntity<MessageDto> addNewPost(@RequestBody PostDTO postDto){
        postService.addPost(postDto);
        return new ResponseEntity<>(new MessageDto("Post creado con éxito"), HttpStatus.OK);
    }

    //EJ10
    @PostMapping("/products/promo-post")
    //public ResponseEntity<MessageDTO> addNewPromoPost(@RequestBody PromoPostDto promoPostDto){
    public ResponseEntity<MessageDto> addNewPromoPost(@RequestBody PostDTO promoPostDto){
        postService.addPost(promoPostDto);
        return new ResponseEntity<>(new MessageDto("Post con promoción creado con éxito"), HttpStatus.OK);
    }

    //EJ11
    //@GetMapping("/products/promo-post/count?user_id={userId}")
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromoCountDto> obtainPromosCountByVendorId(@RequestParam Integer user_id) {
        return ResponseEntity.ok().body(postService.obtainPromosCountByVendorId(user_id));
    }

    //EJ12
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<PromosListDto> obtainPromosByVendorId(@RequestParam Integer user_id) {
        return ResponseEntity.ok().body(postService.obtainPromosByVendorId(user_id));
    }
}
