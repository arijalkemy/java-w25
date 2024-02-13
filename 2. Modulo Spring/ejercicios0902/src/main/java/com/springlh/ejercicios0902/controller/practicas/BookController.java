package com.springlh.ejercicios0902.controller.practicas;

import com.springlh.ejercicios0902.model.practicas.Book;
import com.springlh.ejercicios0902.repository.practicas.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    //inyección por anotación
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
