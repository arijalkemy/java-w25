package com.bootcamp.be_java_hisp_w25_g14.controller;

import com.bootcamp.be_java_hisp_w25_g14.dto.PostDto;
import com.bootcamp.be_java_hisp_w25_g14.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
        return new ResponseEntity<>(postService.savePost(postDto,false), HttpStatus.CREATED);
    }


    /*
    Trabajo individual - US0010 Publicar un nuevo producto en promocion
    METHOD: POST
    BODY: {Integer user_id;String date;ProductDto product;Integer category;
            Double price;boolean has_promo;Double discount;}
    RETURN message;
    RESPONSE: 201
     */
    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromoPost(@RequestBody PostDto promoPostDto){
        return new ResponseEntity<>(postService.savePost(promoPostDto, true),HttpStatus.CREATED);
    }

    /*
    Trabajo individual - US0011 obtener la cantidad de productos en promocion de un determinado vendedor
    METHOD: GET
    VARIABLES: Int userID
    RETURN { Integer user_id; String user_name; Int promo_products_count}
    RESPONSE: 200
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getAmountOfPromoProductsById(@RequestParam Integer user_id){
        return new ResponseEntity<>(postService.getAmountOfPromoProductsById(user_id), HttpStatus.OK);
    }

    /*
    Trabajo individual - US0013 Obtener el mayor descuento sobre el precio de un post
    METHOD: GET
    VARIABLES: NONE
    RETURN { Integer post_id; String user_name; Double discount_percentage; Double price; Double total_discount;}
    RESPONSE: 200
     */
    @GetMapping("/posts/largestDiscount")
    public ResponseEntity<?> getLargestDiscount(){
        return new ResponseEntity<>(postService.getLargestPostDiscount(),HttpStatus.OK);
    }

    /*
        Trabajo individual - US0014 Obtener todos los productos dentro de un rango
        METHOD: GET
        VARIABLES: String from, String to
        RETURN {     String price_range; List<PostDto> posts}
        RESPONSE: 200
         */
    @GetMapping("/posts/priceBetween")
    public ResponseEntity<?> getPostsPriceRange(@RequestParam String from, @RequestParam String to){
        return new ResponseEntity<>(postService.getPostsInRange(from,to),HttpStatus.OK);
    }


}
