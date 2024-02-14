package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.request.BlogDTORequest;
import com.bootcamp.blog.dto.response.BlogDTOResponse;
import com.bootcamp.blog.repository.IBlogRepository;
import com.bootcamp.blog.service.BlogServiceImpl;
import com.bootcamp.blog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BlogController {
    IBlogService blogService;
    public BlogController(){
        blogService = new BlogServiceImpl();
    }

    @PostMapping("/blog")
    public ResponseEntity<BlogDTOResponse> createBlog (@RequestBody BlogDTORequest blogDTORequest){
        BlogDTOResponse blogDTOResponse =  blogService.createBlog(blogDTORequest);

        return new ResponseEntity<>(blogDTOResponse, HttpStatus.CREATED);
    }
    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTOResponse>> getAll(){

        return new ResponseEntity<>(this.blogService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTOResponse> getBlogById (@PathVariable int id){

        return new ResponseEntity<>(this.blogService.getBlogById(id),HttpStatus.OK);
    }

}
