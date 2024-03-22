package com.mercadolibre.literaturaapi.repository;

import com.mercadolibre.literaturaapi.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IBookRepository extends ElasticsearchRepository<Book, String> {
    List<Book> findAll();

    List<Book> findByAuthorContainingIgnoreCase(String author);
    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findFirst5ByOrderByPagesDesc();

    List <Book> findByPublishYearBefore(Integer year);
    List <Book> findByPublisher(String publisher);



}
