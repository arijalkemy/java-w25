package org.example.manejo_de_excepciones_p1_vivo.controller;

import org.example.manejo_de_excepciones_p1_vivo.dto.BlogDto;
import org.example.manejo_de_excepciones_p1_vivo.exception.NotFoundException;
import org.example.manejo_de_excepciones_p1_vivo.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    BlogService blogService = new BlogService();

    @PostMapping("/blog")
    public ResponseEntity<?> createBlog(@RequestBody BlogDto blog){
        return new ResponseEntity<>(blogService.createBlog(blog), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getSingleBlog(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(blogService.getOneBlogById(id),HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getAllBlogs(){
        return new ResponseEntity<>(blogService.getAllBlogs(),HttpStatus.OK);
    }
}
