package blog.controller;

import blog.dto.request.EntradaBlogDTO;
import blog.service.BlogService;
import blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogController {
    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> addBlog(@RequestBody EntradaBlogDTO entradaBlogDTO){
        Integer blogId = blogService.addBlog(entradaBlogDTO);
        return new ResponseEntity<>("Entrada de blog creada correctamente con id " + blogId, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> getBlogById(@PathVariable Integer id){
        return new ResponseEntity<>(blogService.getBlogById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> getAllBlogs(){
        return new ResponseEntity<>(blogService.getAll(), HttpStatus.OK);
    }
}
