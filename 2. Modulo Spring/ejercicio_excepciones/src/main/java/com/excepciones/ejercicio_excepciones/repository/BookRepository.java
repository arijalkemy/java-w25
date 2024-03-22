package com.excepciones.ejercicio_excepciones.repository;

import com.excepciones.ejercicio_excepciones.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository implements IBookRepository{
    List<Book> bookList=new ArrayList<Book>(){{
        add(new Book(1L, "Como programar en Java?", "Manuel"));
        add(new Book(2L, "Servidores: Como administrarlos", "Valencia"));
    }};

    @Override
    public List<Book> getAll() {
        return bookList;
    }

    @Override
    public Book findById(Long id) {
        Optional<Book> first=bookList.stream().filter(book -> book.getId().equals(id)).findFirst();

        if(first.isEmpty()){
            return null;
        }

        return first.get();
    }
}
