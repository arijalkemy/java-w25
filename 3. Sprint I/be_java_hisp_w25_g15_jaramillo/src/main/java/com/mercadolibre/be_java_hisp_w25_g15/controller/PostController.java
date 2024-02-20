package com.mercadolibre.be_java_hisp_w25_g15.controller;

import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.PostWithPromoDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.DateOrderEnumDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostGetListDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostsWithPromoCountDto;
import com.mercadolibre.be_java_hisp_w25_g15.service.IPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor

@RequestMapping("/products")
public class PostController {
    private final IPostService iPostService;


    @PostMapping("/post")
    ResponseEntity<PostDto> createPost(@RequestBody @Valid PostDto post){
        return new ResponseEntity<>(iPostService.createPost(post), HttpStatus.OK);
    }
    @GetMapping("/followed/{userId}/list")
    ResponseEntity<PostGetListDto> getPostsOfFollowedSellersByUserInLastTwoWeeks(
            @PathVariable(name = "userId") int userId,
            @RequestParam(name = "order", required = false) DateOrderEnumDto order
            ){
        return new ResponseEntity<>(iPostService.getPostsOfFollowedSellersByUserInLastTwoWeeks(userId, order), HttpStatus.OK);
    }
    @PostMapping("/promo-post")
    ResponseEntity<PostWithPromoDto> createPostWithPromo(@RequestBody @Valid PostWithPromoDto postWithPromoDto){
        return new ResponseEntity<>(iPostService.createPostWithPromo(postWithPromoDto), HttpStatus.OK);
    }
    @GetMapping("/promo-post/count")
    ResponseEntity<PostsWithPromoCountDto> getQuantityOfPostsWithPromoBySellerId(
            @RequestParam(name = "user_id") int userId
    ){
        return new ResponseEntity<>(iPostService.getQuantityOfPostsWithPromoBySellerId(userId), HttpStatus.OK);
    }
}
