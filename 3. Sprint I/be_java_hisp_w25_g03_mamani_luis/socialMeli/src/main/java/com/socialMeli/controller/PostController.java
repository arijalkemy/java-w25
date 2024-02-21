package com.socialMeli.controller;

import com.socialMeli.dto.request.PostDTO;
import com.socialMeli.dto.response.MessageDto;
import com.socialMeli.dto.response.PromoProductsCountDto;
import com.socialMeli.dto.response.PublicationDto;
import com.socialMeli.service.IPostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PostController {

    private final IPostService postService;

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PublicationDto> obtainLastPublicationsByTheFollowedVendors(
                                                            @PathVariable Integer userId,
                                                            @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(postService
                .obtainLastPublicationsByTheFollowedVendors(userId, order));
    }

    @PostMapping("/products/post")
    public ResponseEntity<MessageDto> addNewPost(@RequestBody PostDTO postDto){
        postService.addPost(postDto);
        return new ResponseEntity<>(new MessageDto("Post creado con éxito"), HttpStatus.OK);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<MessageDto> addNewPromoPost(@RequestBody PostDTO postDto){
        // Verificar si el postDto contiene la información necesaria para la publicación en promoción
        if (postDto.getProduct() != null && postDto.isHasPromo()) {
            postService.addPromoPost(postDto); // Método para agregar el post en promoción
            return new ResponseEntity<>(new MessageDto("Publicación de producto en promoción creada con éxito"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MessageDto("La solicitud no contiene información suficiente para crear la publicación en promoción"), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromoProductsCountDto> getPromoProductsCount(@RequestParam("user_id") Integer userId) {
        PromoProductsCountDto promoProductsCountDto = postService.getPromoProductsCount(userId);
        return ResponseEntity.ok().body(promoProductsCountDto);
    }

}
