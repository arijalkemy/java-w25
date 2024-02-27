package com.mercadolibre.be_java_hisp_w25_g15.controller;

import com.mercadolibre.be_java_hisp_w25_g15.dto.PostDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.PostOfferDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.DateOrderEnumDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.CountOffersDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.PostGetListDto;
import com.mercadolibre.be_java_hisp_w25_g15.model.PostOffer;
import com.mercadolibre.be_java_hisp_w25_g15.service.IPostService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor

@RequestMapping("/products")
public class PostController {
    private final IPostService iPostService;


    @PostMapping("/post")
    ResponseEntity<PostDto> createPost(@RequestBody @Valid PostDto post){
        return new ResponseEntity<>(iPostService.createPost(post), HttpStatus.OK);
    }
    @PostMapping("/promo-post")
    ResponseEntity<PostOfferDto> createPromoPost(@RequestBody @Valid PostOfferDto post){
        return new ResponseEntity<>(iPostService.createPostOffer(post), HttpStatus.OK);
    }
    @GetMapping("/followed/{userId}/list")
    ResponseEntity<PostGetListDto> getPostsBySellerIdLastTwoWeeks(
            @PathVariable(name = "userId") int userId,
            @RequestParam(name = "order", required = false) DateOrderEnumDto order
            ){
        return new ResponseEntity<>(iPostService.getPostsBySellerIdLastTwoWeeks(userId, order), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    ResponseEntity<CountOffersDto> countPromoPostsByUserId(@RequestParam(name = "user_id") @NonNull int userId){
        return new ResponseEntity<>(iPostService.countPromoPostsByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    ResponseEntity<List<PostOffer>> getPromoPostsByUserId(@RequestParam(name = "user_id") @NonNull int userId){
        return new ResponseEntity<>(iPostService.getPromoPostsByUserId(userId), HttpStatus.OK);
    }


}
