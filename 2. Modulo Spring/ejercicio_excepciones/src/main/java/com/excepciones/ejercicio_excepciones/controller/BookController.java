package com.excepciones.ejercicio_excepciones.controller;

import com.excepciones.ejercicio_excepciones.entity.Book;
import com.excepciones.ejercicio_excepciones.service.BookService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    List<Book> getAllBooks(){
        return  bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    Book getBookById(@PathVariable Long id){
        return  bookService.getBookById(id);
    }
}
