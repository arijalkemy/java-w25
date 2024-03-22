package com.excepciones.ejercicio_excepciones.service;

import com.excepciones.ejercicio_excepciones.entity.Book;
import com.excepciones.ejercicio_excepciones.exceptions.NotFoundException;
import com.excepciones.ejercicio_excepciones.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAll();
    }

    @Override
    public Book getBookById(Long id) {
        Book libroEncontrado=bookRepository.findById(id);

        if(libroEncontrado==null){
            // Implementando excepcion personalizada
            throw new NotFoundException("Libro con la id: "+id+" no fue encontrado");
        }

        return libroEncontrado;
    }
}
