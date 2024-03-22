package com.mercadolibre.literaturaapi.service;

import com.mercadolibre.literaturaapi.dto.BookDto;
import com.mercadolibre.literaturaapi.dto.ResposeDto;

import java.util.List;

public interface IBookService {
    List<BookDto> findAll();
    List<BookDto> findTop5MostPages();

    List<BookDto> findByAuthor(String author);
    List<BookDto> findByPublisher(String publisher);

    List<BookDto> findByTitle(String title);
    List<BookDto> findBeforePublishYear(Integer year);
    ResposeDto save(BookDto bookDto);


}
