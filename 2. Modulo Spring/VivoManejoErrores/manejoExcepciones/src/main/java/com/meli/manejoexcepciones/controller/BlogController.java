package com.meli.manejoexcepciones.controller;

import com.meli.manejoexcepciones.dto.blog.BlogDTO;
import com.meli.manejoexcepciones.dto.common.ResponseDTO;
import com.meli.manejoexcepciones.service.IBlogService;
import com.meli.manejoexcepciones.service.impl.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    IBlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<ResponseDTO> createBlogPost(
            @RequestBody BlogDTO blogDTO){
        return ResponseEntity.ok(blogService.create(blogDTO));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> getById(
            @PathVariable int id){
        return ResponseEntity.ok(blogService.getById(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getAll(){
        return ResponseEntity.ok(blogService.getAll());
    }
}

