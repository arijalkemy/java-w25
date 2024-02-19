package org.bootcamp.blog.controller;

import org.bootcamp.blog.dto.BlogDto;
import org.bootcamp.blog.dto.ResponseDto;
import org.bootcamp.blog.model.EntradaBlog;
import org.bootcamp.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<ResponseDto> addBlog(@RequestBody BlogDto blog){
        this.blogService.addBlog(blog);
        return ResponseEntity.ok().body(new ResponseDto("Blog creado correctamente"));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> getAllBlogs(){
        return ResponseEntity.ok().body(this.blogService.getAllBlogs());
    }

    @GetMapping("/blog/{blogId}")
    public ResponseEntity<BlogDto> getBlogById(@PathVariable int blogId){
        return ResponseEntity.ok().body(this.blogService.getBlogById(blogId));
    }
}
