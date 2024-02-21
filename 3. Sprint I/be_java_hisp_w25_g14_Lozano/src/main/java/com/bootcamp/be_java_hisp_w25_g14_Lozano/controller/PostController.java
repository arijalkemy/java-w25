package com.bootcamp.be_java_hisp_w25_g14_Lozano.controller;

import com.bootcamp.be_java_hisp_w25_g14_Lozano.dto.PostDto;
import com.bootcamp.be_java_hisp_w25_g14_Lozano.service.IPostService;
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

    /* 12. Obtener un listado de todos los productos en promoción de un determinado vendedor  */
    @GetMapping("/promo-post/list")
    public ResponseEntity<List<PostDto>> listProductPostCount(@RequestParam ("userId") Integer userId){

    return new ResponseEntity<>(this.postService.listProductPostCount(userId),HttpStatus.OK);
    }

    /* 11. Obtener la cantidad de productos en promoción de un determinado vendedor */
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getCountProductPromo(@RequestParam ("user_id") Integer userId) {
        return new ResponseEntity<>(this.postService.getProductPostCount(userId),HttpStatus.OK);
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

    /* 10. Llevar a cabo la publicación de un nuevo producto en promoción. */
    @PostMapping("/promo-post")
    public ResponseEntity<?> savePromoPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.savePost(postDto), HttpStatus.OK);
    }

}
