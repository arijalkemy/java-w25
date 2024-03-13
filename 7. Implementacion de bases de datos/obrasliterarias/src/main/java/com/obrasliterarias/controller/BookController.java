package com.obrasliterarias.controller;

import com.obrasliterarias.dto.BookDto;
import com.obrasliterarias.dto.BookRequestDto;
import com.obrasliterarias.dto.ResponseDto;
import com.obrasliterarias.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final IBookService bookService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createBook(@RequestBody BookRequestDto bookRequestDto){
        return ResponseEntity.ok().body(bookService.saveBook(bookRequestDto));
    }
    @GetMapping("/{autor}")
    public ResponseEntity<List<BookDto>> getBooksByAutor(@PathVariable String autor){
        return ResponseEntity.ok().body(bookService.getBooksByAutor(autor));
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllBooks(){
        return ResponseEntity.ok().body(
                bookService.getAllBooks()
        );
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> getBooksByPublisher(
            @PathVariable String editorial
    ) {
        return ResponseEntity.ok(bookService.getBooksByPublisher(editorial));
    }

    @GetMapping("/before/{year}")
    public ResponseEntity<?> getBooksBeforeYear(@PathVariable("year") Integer year) {
        return new ResponseEntity<>(bookService.getBooksBeforeYear(year), HttpStatus.OK);
    }

    @GetMapping("/top5")
    public ResponseEntity<?> getTop5BooksByTotalPages(){
        return new ResponseEntity<>(bookService.getTop5BooksByTotalPagesOrderDesc(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<BookDto>> getBooksByName(
            @PathVariable String name
    ){
        return new ResponseEntity<>(
            this.bookService.getByName(name),
                HttpStatus.OK
        );
    }
}
