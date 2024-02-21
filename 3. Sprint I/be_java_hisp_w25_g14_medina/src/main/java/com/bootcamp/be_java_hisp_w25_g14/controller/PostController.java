package com.bootcamp.be_java_hisp_w25_g14.controller;

import com.bootcamp.be_java_hisp_w25_g14.dto.MessageDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.PostDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.PromoPostDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserFollowedPostDto;
import com.bootcamp.be_java_hisp_w25_g14.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/products")
public class PostController {

    private IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/getAllPosts")
    public ResponseEntity<?> findAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPostsLastTwoWeeks(@PathVariable Integer userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(postService.getFollowedPostsByUserLastTwoWeeks(userId,order),HttpStatus.OK);
    }


    @PostMapping("/post")
    public ResponseEntity<?> savePost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.savePost(postDto), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> savePostPromo(@RequestBody PromoPostDto promoPostDto){
        return new ResponseEntity<>(postService.savePromoPost(promoPostDto), HttpStatus.OK);
    }


    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getCountPromo(@RequestParam Integer user_id) {
        return new ResponseEntity<>(this.postService.getPromoProductsCount(user_id),HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getListPromo(@RequestParam Integer user_id) {
        return new ResponseEntity<>(this.postService.getPromoProductsList(user_id),HttpStatus.OK);
    }

    /*
    Obtener el mejor precio de descuento total de las promociones de los post de nuestro
    vendedore seguidos seguidos
     */
    @GetMapping("/promo-post/{user_id}/best-promo")
    public ResponseEntity<?> getBestPromo(@PathVariable Integer user_id) {
        return new ResponseEntity<>(this.postService.getBestPromo(user_id),HttpStatus.OK);
    }
}
