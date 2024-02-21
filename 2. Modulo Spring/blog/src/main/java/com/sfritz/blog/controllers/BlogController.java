package com.sfritz.blog.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sfritz.blog.dtos.BlogDto;
import com.sfritz.blog.services.IBlogService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class BlogController {

    private IBlogService service;

    public BlogController(IBlogService service){
        this.service = service;
    }

    @PostMapping("/blog")
    public ResponseEntity<BlogDto> createBlog(@RequestBody BlogDto request) {
        service.createBlog(request);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDto> getBlogById(@PathVariable Integer id) {
        return new ResponseEntity<>(service.getBlogById(id), HttpStatus.OK);
    }
    
    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> getAllBlogs() {
        return new ResponseEntity<>(service.getAllBlogs(), HttpStatus.OK);
    }
}
