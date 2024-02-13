package com.springlh.ejercicios0902.repository.practicas;

import com.springlh.ejercicios0902.model.practicas.Book;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepository {
    public List<Book> findAll() {
        List<Book> bookList = Arrays.asList(
                new Book(1L, "La Metamorfosis", "Franz Kafka"),
                new Book(2L, "Winnie Pooh", "A. A. Milne")
        );
        return bookList;
    }
}
