package com.example.exceptions.controller;

import com.example.exceptions.dto.BlogCreationDto;
import com.example.exceptions.dto.BlogDto;
import com.example.exceptions.entity.EntradaBlog;
import com.example.exceptions.service.EntradaBlogService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BlogController {

    private final EntradaBlogService entradaBlogService;


    @PostMapping("/blog")
    public ResponseEntity<BlogCreationDto> newBlog(@RequestBody EntradaBlog newBlog){
        return ResponseEntity.ok(entradaBlogService.createBlog(newBlog));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDto> getBlogById(@PathVariable int id){
        return ResponseEntity.ok(entradaBlogService.getBlogById(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> allBlogs(){
        return ResponseEntity.ok(entradaBlogService.getAllBlogs());
    }
}
