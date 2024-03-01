package com.grupo08.socialmeli.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.grupo08.socialmeli.dto.PostDto;
import com.grupo08.socialmeli.service.IPostService;
import com.grupo08.socialmeli.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/products")
@Validated
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
    public ResponseEntity<?> followProcducts(@Positive(message = "El id debe ser mayor a 0.")
                                                 @PathVariable("userId") Integer idUser,
                                             @RequestParam(required = false)  String order){
        if(order==null){
            return new ResponseEntity<>(userService.postSortWeeks(idUser),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(userService.postSortDate(idUser,order),HttpStatus.OK);

        }

    }

    @PostMapping("/post")
    public ResponseEntity<?> insertPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.insertPost(postDto),HttpStatus.OK);
    }

}
