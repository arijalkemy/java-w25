package blog.controller;

import blog.dto.EntradaBlogDTO;
import blog.dto.SuccessDTO;
import blog.service.BlogServiceimpl;
import blog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Blog {
    private final IBlogService blogService;

    public Blog(BlogServiceimpl blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<SuccessDTO> createEntradaBlog(@RequestBody EntradaBlogDTO entradaBlogDTO) {
        blogService.addEntradaBlog(entradaBlogDTO);
        return new ResponseEntity<>(
            new SuccessDTO(
                "Recurso creado exitosamente",
                "Entrada de blog creada con éxito (id = " + entradaBlogDTO.getId().toString() + ")"
            ),
            HttpStatus.CREATED
        );
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> findEntradaBlogById(@PathVariable Integer id) {
        return new ResponseEntity<>(
            blogService.findEntradaBlogById(id),
            HttpStatus.OK
        );
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> findAllEntradasBlog() {
        return new ResponseEntity<>(
            blogService.findAllEntradasBlog(),
            HttpStatus.OK
        );
    }
}