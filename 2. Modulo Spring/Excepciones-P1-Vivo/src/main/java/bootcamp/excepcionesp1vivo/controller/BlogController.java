package bootcamp.excepcionesp1vivo.controller;

import bootcamp.excepcionesp1vivo.entity.EntradaBlog;
import bootcamp.excepcionesp1vivo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @PostMapping("blog")
    public ResponseEntity<?> createBlog(@RequestBody EntradaBlog blog) {
        blogService.createBlog(blog);
        return ResponseEntity.status(HttpStatus.CREATED).body("Blog creado con éxito");
    }

    @GetMapping("blog/{id}")
    public ResponseEntity<EntradaBlog> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(blogService.findById(id));
    }

    @GetMapping("blogs")
    public ResponseEntity<List<EntradaBlog>> findAll() {
        return ResponseEntity.ok(blogService.findAll());
    }

}
