package com.exceptionhandlers.service;

import com.exceptionhandlers.entity.Book;
import com.exceptionhandlers.exceptions.NotFoundException;
import com.exceptionhandlers.repository.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements IBookService{
    private final IBookRepository bookRepository;

    public BookService (IBookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public Book findById(Long id) {
        Book foundedBook = bookRepository.findById(id);
        if (foundedBook == null) throw new NotFoundException("El libro no se encontro");
        return foundedBook;
    }
}
