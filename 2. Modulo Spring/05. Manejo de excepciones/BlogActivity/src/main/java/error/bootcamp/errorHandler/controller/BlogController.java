package error.bootcamp.errorHandler.controller;

import error.bootcamp.errorHandler.dto.blog.BlogDTO;
import error.bootcamp.errorHandler.dto.common.ResponseDto;
import error.bootcamp.errorHandler.service.common.IBlogService;
import error.bootcamp.errorHandler.service.impl.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    IBlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<ResponseDto> createBlogPost(
            @RequestBody BlogDTO blogDTO){
            return ResponseEntity.ok(blogService.create(blogDTO));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> getById(
            @PathVariable int id){
        return ResponseEntity.ok(blogService.getById(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> getAll(){
        return ResponseEntity.ok(blogService.getAll());
    }
}
