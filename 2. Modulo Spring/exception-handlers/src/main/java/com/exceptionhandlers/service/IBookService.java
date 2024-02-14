package com.exceptionhandlers.service;

import com.exceptionhandlers.entity.Book;

import java.util.List;

public interface IBookService {
    public List<Book> getAllBooks();
    public Book findById(Long id);
}
