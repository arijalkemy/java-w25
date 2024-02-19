package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.BlogDto;
import com.mercadolibre.blog.dto.SuccesDto;
import com.mercadolibre.blog.service.BlogService;
import com.mercadolibre.blog.utils.Mapeador;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BlogController {

    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog")
    public ResponseEntity<List<BlogDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(blogService.getAll());
    }

    @PostMapping("/blog")
    public ResponseEntity<SuccesDto> add(@RequestBody BlogDto blogDto){
        this.blogService.add(blogDto);
        return ResponseEntity.status(201).body(new SuccesDto("New blog pasted", Mapeador.BASEURI+blogDto.getId()));
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDto> getById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(this.blogService.findById(id));
    }
}
