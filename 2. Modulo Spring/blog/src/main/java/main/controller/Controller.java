package main.controller;

import main.dto.RequestBlogDTO;
import main.dto.ResponseBlogsDTO;
import main.entity.EntryBlog;
import main.service.IEntryBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    IEntryBlogService entryBlogService;

    @PostMapping("/blog")
    public ResponseEntity<?> insertEntityBlog (@RequestBody RequestBlogDTO requestBlogDTO){
        EntryBlog entry = entryBlogService.createBlog(
                new EntryBlog(requestBlogDTO.getId(), requestBlogDTO.getTitle()
                        , requestBlogDTO.getAutor(),requestBlogDTO.getDate()));

        return ResponseEntity.status(HttpStatus.OK).body("Se creo el blog con el id "+ entry.getId() + " correctamente");
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<ResponseBlogsDTO>> getAllsEntityBlogs (){
        return new ResponseEntity<>(entryBlogService.getAllBlogs(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<ResponseBlogsDTO> getEntityBlogById (@PathVariable int id){
        return new ResponseEntity<>(entryBlogService.getBlogById(id), HttpStatus.OK);
    }
}
