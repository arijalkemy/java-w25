package com.manejoExcepciones.blogAPI.Controller;


import com.manejoExcepciones.blogAPI.DTOs.BlogRequestDTO;
import com.manejoExcepciones.blogAPI.DTOs.BlogResponseDTO;
import com.manejoExcepciones.blogAPI.Exceptions.BlogAlreadyExistsException;
import com.manejoExcepciones.blogAPI.Exceptions.BlogNotFoundException;
import com.manejoExcepciones.blogAPI.Service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<String> addBlog(@RequestBody BlogRequestDTO blogRequestDTO){
        if(!blogService.addBlog(blogRequestDTO)){
            throw new BlogAlreadyExistsException("El blog ya se encuentra registrado.");
        }
        return ResponseEntity.ok().body("El blog con el id " + blogRequestDTO.getId() + " ha sido creado exitosamente");
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogResponseDTO> getBlog(@PathVariable Integer id){
        BlogResponseDTO blogResponseDTO = blogService.getBlog(id);
        if(blogResponseDTO == null){
            throw new BlogNotFoundException("El blog no se encuentra registrado");
        }
        return ResponseEntity.ok().body(blogResponseDTO);
    }
    @GetMapping("/blogs")
    public ResponseEntity<List<BlogResponseDTO>> getBlogs(){
        return ResponseEntity.ok().body(blogService.getBlogs());
    }

}
