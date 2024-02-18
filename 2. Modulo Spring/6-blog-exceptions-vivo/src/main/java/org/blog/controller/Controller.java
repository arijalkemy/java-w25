package org.blog.controller;

import org.blog.dto.response.EntradaBlogDTO;
import org.blog.dto.response.SuccessCreateResponseDTO;
import org.blog.service.EntradaService;
import org.blog.service.IEntradaService;
import org.blog.utils.EntradaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    private final IEntradaService blogService;

    @Autowired
    public Controller(EntradaService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<SuccessCreateResponseDTO> newBlogEntry(@RequestBody EntradaBlogDTO entry) {
        blogService.createBlogEntry(EntradaMapper.fromDTO(entry));

        SuccessCreateResponseDTO res = new SuccessCreateResponseDTO("Se ha creado correctamente la entrada de blog con id " + entry.getId());

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> getBlogEntry(@PathVariable Long id) {
        EntradaBlogDTO res = blogService.getBlogEntryById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> getAllBlogs() {
        List<EntradaBlogDTO> res = blogService.getAllBlogEntries();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
