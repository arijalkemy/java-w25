package com.mercadolibre.literaturaapi.controller;

import com.mercadolibre.literaturaapi.dto.BookDto;
import com.mercadolibre.literaturaapi.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookController {

    final
    IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(bookService.findAll());
    }

    @GetMapping("/books/author")
    public ResponseEntity<?> findByAuthor(@RequestParam String author){
        return ResponseEntity.ok().body(bookService.findByAuthor(author));
    }

    @GetMapping("/books/title")
    public ResponseEntity<?> findByTitle(@RequestParam String title){
        return ResponseEntity.ok().body(bookService.findByTitle(title));
    }
    @GetMapping("/books/publish_year")
    public ResponseEntity<?> findBeforePublishYear(@RequestParam Integer year){
        return ResponseEntity.ok().body(bookService.findBeforePublishYear(year));
    }
    @GetMapping("/books/publisher")
    public ResponseEntity<?> findByPublisher(@RequestParam String publisher){
        return ResponseEntity.ok().body(bookService.findByPublisher(publisher));
    }

    @PostMapping("/books")
    public ResponseEntity<?> save(@RequestBody BookDto bookDto){
        return ResponseEntity.ok().body(bookService.save(bookDto));
    }

    @GetMapping("/books/top_pages")
    public ResponseEntity<?> findTopPages(){
        return ResponseEntity.ok().body(bookService.findTop5MostPages());
    }
}
