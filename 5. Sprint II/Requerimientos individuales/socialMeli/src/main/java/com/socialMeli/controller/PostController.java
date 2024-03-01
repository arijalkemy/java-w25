package com.socialMeli.controller;

import com.socialMeli.dto.request.PostDTO;
import com.socialMeli.dto.response.MessageDto;
import com.socialMeli.dto.response.PublicationDto;
import com.socialMeli.service.IPostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@RestController
@AllArgsConstructor
@Validated
public class PostController {

    private final IPostService postService;

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PublicationDto> obtainLastPublicationsByTheFollowedVendors(
            @Positive(message = "El id debe ser un valor positivo")
            @NotNull(message = "El id de usuario no puede estar vacio")
            @PathVariable Integer userId,
            @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(postService
                .obtainLastPublicationsByTheFollowedVendors(userId, order));
    }

    @PostMapping("/products/post")
    public ResponseEntity<MessageDto> addNewPost(@Valid @RequestBody PostDTO postDto){
        postService.addPost(postDto);
        return new ResponseEntity<>(new MessageDto("Post creado con éxito"), HttpStatus.OK);
    }
}
