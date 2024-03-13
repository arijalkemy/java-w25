package com.obrasliterarias.service;

import com.obrasliterarias.dto.BookDto;
import com.obrasliterarias.dto.BookRequestDto;
import com.obrasliterarias.dto.ResponseDto;
import com.obrasliterarias.model.Book;

import java.util.List;

public interface IBookService {
    ResponseDto saveBook(BookRequestDto bookRequestDto);

    List<BookDto> getBooksByAutor(String autor);
    public List<BookDto> getAllBooks();
    public List<BookDto> getBooksBeforeYear(Integer year);

    List<BookDto> getBooksByPublisher(String editorial);
    List<BookDto> getByName(String name);
    List<BookDto> getTop5BooksByTotalPagesOrderDesc();
}
