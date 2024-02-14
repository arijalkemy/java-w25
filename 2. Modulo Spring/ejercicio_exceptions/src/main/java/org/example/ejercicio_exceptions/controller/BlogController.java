package org.example.ejercicio_exceptions.controller;

import org.example.ejercicio_exceptions.dto.BlogEntryDTO;
import org.example.ejercicio_exceptions.dto.BlogSaveRequestDTO;
import org.example.ejercicio_exceptions.dto.BlogSavedResponseDTO;
import org.example.ejercicio_exceptions.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<BlogSavedResponseDTO> saveBlog(@RequestBody BlogSaveRequestDTO blogSaveRequestDTO){
        return ResponseEntity.ok(blogService.saveBlog(blogSaveRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogEntryDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(blogService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<BlogEntryDTO>> findAll(){
        return ResponseEntity.ok(blogService.findAll());
    }


}
