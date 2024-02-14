package com.exceptionhandlers.repository;

import com.exceptionhandlers.entity.Book;

import java.util.List;

public interface IBookRepository {
    public List<Book> getAllBooks();
    public Book findById(Long id);
}
