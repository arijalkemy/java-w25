package youtuber.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import youtuber.blog.DTO.request.CreateBlogPostRequest;
import youtuber.blog.DTO.response.EntradaBlogDTO;
import youtuber.blog.entity.EntradaBlog;
import youtuber.blog.service.EntradaBlogService;
import youtuber.blog.service.IEntradaBlogService;

import java.util.List;

@RestController
public class EntradaBlogController {
    IEntradaBlogService service;

    public EntradaBlogController (EntradaBlogService service) {
        this.service = service;
    }

    @PostMapping("/blog") //punto 1
    public ResponseEntity<EntradaBlogDTO> postNewBlog (@RequestBody CreateBlogPostRequest createPostRequest) {
        return new ResponseEntity<>(service.postNew(createPostRequest), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}") //punto 2
    public ResponseEntity<EntradaBlogDTO> getBlogById (@PathVariable Long id) {
        EntradaBlogDTO entradaBlogDTO = service.getBlogById(id);
        return ResponseEntity.ok(entradaBlogDTO);
    }

    @GetMapping("/blogs") //punto 3
    public ResponseEntity<List<EntradaBlogDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
