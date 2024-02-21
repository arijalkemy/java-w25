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
    /**
     * Metodo para guardar una nueva promoción con desceunto, a la cual se le pasa
     * como parámetro, en el body de la petición, un objeto de tipo PromoPostDto
     * el cual es una clase que hereda de la clase PostDto pero agrega los dos
     * atributos que identifican a un post con desceunto
     */
    @PostMapping("/promo-post")
    public ResponseEntity<?> savePromoPost(@RequestBody PromoPostDto promoPostDto){
        return new ResponseEntity<>(postService.savePromoPost(promoPostDto), HttpStatus.OK);
    }

    /**
    * Para este endpoint se hace uso de un parámetro en la petición para identificar al usuario
     * que está haciendo la publicación
    * */
    @GetMapping("/promo-post")
    public ResponseEntity<?> getQtyPromoPost(@RequestParam Integer userId){
        return new ResponseEntity<>(postService.getQtyUserPromoPost(userId),HttpStatus.OK);
    }

    /**
     * Finalmente para la funcionalidad BONUS se hizo un endpoint que al igual que el anterior
     * recibe el id del user, pero con una notación diferente de snape case
     * */
    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getPromoPostList(@RequestParam Integer user_id){
        return new ResponseEntity<>(postService.getPromoPostList(user_id),HttpStatus.OK);
    }

}
