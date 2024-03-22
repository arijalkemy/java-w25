package com.excepciones.ejercicio_excepciones.repository;

import com.excepciones.ejercicio_excepciones.entity.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> getAll();
    Book findById(Long id);
}
