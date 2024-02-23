package com.grupo08.socialmeli.controller;

import com.grupo08.socialmeli.dto.request.PostPromoDto;
import com.grupo08.socialmeli.service.IPostPromoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import com.grupo08.socialmeli.dto.PostDto;
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

    @Autowired
    IPostPromoService postPromoService;

    @GetMapping("/post/getAll")
    public ResponseEntity<?> getAllPosts() {
        return new ResponseEntity<>(postService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followProcducts(@PathVariable("userId") Long idUser,@RequestParam(required = false)  String order){
        System.out.println("-------"+order+"--------");
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

    @PostMapping("/promo-post")
    public ResponseEntity<?> insertPostPromo(@RequestBody PostPromoDto postPromoDto) {
        return new ResponseEntity<>(postPromoService.insertPostPromo(postPromoDto),HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public  ResponseEntity<?> getPromosBySeller( @RequestParam("user_id") int userId){
        return new ResponseEntity<>(postPromoService.getPromosBySeller(userId),HttpStatus.OK);
    }
}
