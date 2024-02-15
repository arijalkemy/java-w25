package com.bootcamp.controller;

import com.bootcamp.dto.BlogDto;
import com.bootcamp.dto.CreatedBlogDto;
import com.bootcamp.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService service;
    @PostMapping("")
    public ResponseEntity<CreatedBlogDto> createBlog(
            @RequestBody BlogDto blogDto
            ){
        return new ResponseEntity<>(service.createBlog(blogDto), HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDto> findById(@PathVariable Integer id){

        return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> findById(){

        return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
    }
}
