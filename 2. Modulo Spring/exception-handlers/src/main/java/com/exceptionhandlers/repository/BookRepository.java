package com.exceptionhandlers.repository;

import com.exceptionhandlers.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Repository
public class BookRepository implements IBookRepository {
    List<Book> bookList = new ArrayList<>(List.of(
            new Book(1L, "Programando en Java", "Facundo Salvia"),
            new Book(2L, "Mobidick", "Dickinson")
    ));

    @Override
    public List<Book> getAllBooks() {
        return bookList;
    }

    @Override
    public Book findById(Long id) {
        return bookList.stream()
                .filter(book -> Objects.equals(book.getId(), id))
                .findFirst()
                .orElse(null);
    }
}
