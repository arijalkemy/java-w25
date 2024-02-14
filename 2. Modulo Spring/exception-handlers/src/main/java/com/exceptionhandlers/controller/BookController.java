package com.exceptionhandlers.controller;

import com.exceptionhandlers.entity.Book;
import com.exceptionhandlers.service.IBookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private final IBookService bookService;
    public BookController(IBookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {return bookService.getAllBooks();}

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id){ return  bookService.findById(id);}
}
