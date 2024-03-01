package com.example.youtuber.controller;

import com.example.youtuber.dto.EntradaBlogDto;
import com.example.youtuber.dto.ResponseDto;
import com.example.youtuber.service.IYoutuberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class YoutuberController {
    @Autowired
    IYoutuberService service;

    @PostMapping("/blog")
    public ResponseEntity<ResponseDto> agregarBlog(@RequestBody EntradaBlogDto blog) {
        this.service.addBlog(blog);
        return ResponseEntity.ok().body( new ResponseDto("Blog creado exitosamente"));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDto>> getAllBlogs(){
        List<EntradaBlogDto> blogs = this.service.getAllBlogs();
        return ResponseEntity.ok().body(blogs);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDto> getBlog(@PathVariable int id ){
        return ResponseEntity.ok().body(this.service.getById(id));
    }

}
