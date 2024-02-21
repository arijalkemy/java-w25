package com.bootcamp.be_java_hisp_w25_g14.controller;

import com.bootcamp.be_java_hisp_w25_g14.dto.MessageDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.PostDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.PostFullDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.UserFollowedPostDto;
import com.bootcamp.be_java_hisp_w25_g14.exceptions.NotFoundException;
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

    /**
     *
     * metodo para retornar todos los posts que existan guardados
     *
     * @return List<PostDto> si encuentra elementos guardados
     *
     */
    @GetMapping("/getAllPosts")
    public ResponseEntity<?> findAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    /**
     * Punto individual Opcional 13
     *
     * metodo para retornar todos los posts con descuentos  que existan guardados
     *
     * @return List<PostFullDto> si encuentra elementos guardados
     *
     */
    @GetMapping("/getAllPostsDiscount")
    public ResponseEntity<?> findAllPostsFull(){
        return new ResponseEntity<>(postService.getAllPostsFull(), HttpStatus.OK);
    }




    /**
     * Punto individual Opcional 12
     *
     * metodo para retornar todos los posts con descuentos  que tenga un determinado Usuario
     *
     * @return List<PostFullDto> si encuentra elementos guardados
     *
     */
    @GetMapping("/getAllPostsDiscount/{id}")
    public ResponseEntity<?> findAllPostsFullByUserId(@PathVariable int id){
        return new ResponseEntity<>(postService.getPostOnDiscountBySeller(id), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedPostsLastTwoWeeks(@PathVariable Integer userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(postService.getFollowedPostsByUserLastTwoWeeks(userId,order),HttpStatus.OK);
    }

    /**
     * Punto individual 11
     *
     * metodo para retornar la cantidad de descuentos que tiene publicados un vendedor
     *
     * @return PostOnDiscountCountDto si encuentra elementos guardados
     *
     */
    @GetMapping("/getCountDiscountsBySeller/{id}")
    public ResponseEntity<?> getCountDiscountsBySellerId(@PathVariable Integer id){
        return new ResponseEntity<>(postService.postOnDiscountCountBySeller(id),HttpStatus.OK);
    }



    /**
     * metodo para crear un post sin descuentos
     *
     * @return MessageDto si encuentra elementos guardados
     *
     */
    @PostMapping("/post")
    public ResponseEntity<?> savePost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.savePost(postDto), HttpStatus.OK);
    }

    /**
     * Punto individual 10
     *
     * metodo para crear un post con descuentos
     *
     * @return MessageDto si encuentra elementos guardados
     *
     */
    @PostMapping("/postDiscount")
    public ResponseEntity<?> savePostFull(@RequestBody PostFullDto postFullDto){
        return new ResponseEntity<>(postService.savePostDiscount(postFullDto), HttpStatus.OK);
    }


}
