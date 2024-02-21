package com.grupo08.socialmeli.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.grupo08.socialmeli.dto.PostDto;
import com.grupo08.socialmeli.dto.PostPromoDto;
import com.grupo08.socialmeli.service.IPostService;
import com.grupo08.socialmeli.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IPostService postService;

    @Autowired
    IUserService userService;

    @GetMapping("/post/getAll")
    public ResponseEntity<?> getAllPosts() {
        return new ResponseEntity<>(postService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followProcducts(@PathVariable Long idUser,@RequestParam  String order){
        if(order==null){
            return new ResponseEntity<>(userService.postSortWeeks(idUser),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(userService.postSortDate(idUser,order),HttpStatus.OK);

        }

    }

    @PostMapping("/post")
    public ResponseEntity<?> insertPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.insertPost(postDto),HttpStatus.OK);
    }

    // Post Promo

    @GetMapping("/postPromo/getAll")
    public ResponseEntity<?> getAllPostPromos() {
        return new ResponseEntity<>(postService.getAllPromos(),HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> insertPostPromo(@RequestBody PostPromoDto postPromoDto) {
        return new ResponseEntity<>(postService.insertPostPromo(postPromoDto),HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostxSeller(@RequestParam int user_id) {
        return new ResponseEntity<>(postService.getPromoPostxSeller(user_id),HttpStatus.OK);
    }

}
