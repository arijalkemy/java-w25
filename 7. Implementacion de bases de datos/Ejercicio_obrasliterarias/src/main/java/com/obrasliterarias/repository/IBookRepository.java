package com.obrasliterarias.repository;

import com.obrasliterarias.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
public interface IBookRepository extends ElasticsearchRepository<Book, String> {
    List<Book> findAll();
    List<Book> findBooksByAutor(String autor);
    List<Book> findBooksByPublicationYearBefore(Integer year);
    List<Book> findBooksByEditorial(String editorial);
    List<Book> findTop5ByOrderByTotalPagesDesc();
    List<Book> findByNameContaining(String query);
}
