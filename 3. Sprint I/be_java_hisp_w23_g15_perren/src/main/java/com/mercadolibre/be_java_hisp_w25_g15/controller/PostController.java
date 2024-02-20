package com.mercadolibre.be_java_hisp_w25_g15.controller;

import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.DateOrderEnumDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostGetListDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostGetPromoListDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PromoPostCountDto;
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
    ResponseEntity<PostGetListDto> getPostsBySellerIdLastTwoWeeks(
            @PathVariable(name = "userId") int userId,
            @RequestParam(name = "order", required = false) DateOrderEnumDto order
            ){
        return new ResponseEntity<>(iPostService.getPostsBySellerIdLastTwoWeeks(userId, order), HttpStatus.OK);
    }
    @PostMapping("/promo-post")
    public ResponseEntity<PostDto> postPromoProduct(@RequestBody PostDto postDto) {

        return new ResponseEntity<>(iPostService.createPost(postDto), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDto> countPromoPost(@RequestParam("user_id") int userId) {
        return new ResponseEntity<>(iPostService.countPromoPost(userId), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PostGetPromoListDto> getPromoPostList(@RequestParam("user_id") int userId, @RequestParam(name = "order", required = false) String order) {
        return new ResponseEntity<>(iPostService.getPromoPostListByUser(userId,order), HttpStatus.OK);
    }

}
