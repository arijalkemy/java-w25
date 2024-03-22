package com.excepciones.ejercicio_excepciones.service;

import com.excepciones.ejercicio_excepciones.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
}
