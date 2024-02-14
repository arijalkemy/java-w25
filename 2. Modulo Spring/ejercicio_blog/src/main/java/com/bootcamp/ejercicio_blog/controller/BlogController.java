package com.bootcamp.ejercicio_blog.controller;

import com.bootcamp.ejercicio_blog.dto.EntradaBlogDTO;
import com.bootcamp.ejercicio_blog.service.BlogServiceImpl;
import com.bootcamp.ejercicio_blog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class BlogController {
    private IBlogService blogServiceImpl;
    public BlogController(BlogServiceImpl blogService){
        this.blogServiceImpl = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<EntradaBlogDTO> crearBlog(@RequestBody EntradaBlogDTO blog){
        return ResponseEntity.status(HttpStatus.OK).body( this.blogServiceImpl.save(blog));
    }

    @GetMapping("/blog/{id}")
    public  ResponseEntity<EntradaBlogDTO> devolverBlog(@PathVariable int id){
        return ResponseEntity.ok(this.blogServiceImpl.getByID(id));
    }

    @GetMapping("/blog")
    public ResponseEntity<List<EntradaBlogDTO>> listarBlogs(){
        return ResponseEntity.ok(this.blogServiceImpl.getAll());
    }

}
