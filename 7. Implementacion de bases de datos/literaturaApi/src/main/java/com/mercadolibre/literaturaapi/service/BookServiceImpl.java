package com.mercadolibre.literaturaapi.service;

import com.mercadolibre.literaturaapi.dto.BookDto;
import com.mercadolibre.literaturaapi.dto.ResposeDto;
import com.mercadolibre.literaturaapi.model.Book;
import com.mercadolibre.literaturaapi.repository.IBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements IBookService {

    final IBookRepository bookRepository;
    final ModelMapper mapper;

    public BookServiceImpl(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
        mapper = new ModelMapper();
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream().map(book -> mapper.map(book,BookDto.class)).toList();
    }

    @Override
    public List<BookDto> findTop5MostPages() {
        return bookRepository.findFirst5ByOrderByPagesDesc().stream().map(book -> mapper.map(book,BookDto.class)).toList();
    }

    public List<BookDto> findByAuthor(String author){
        return bookRepository.findByAuthorContainingIgnoreCase(author).stream().map(book -> mapper.map(book, BookDto.class)).toList();
    }

    @Override
    public List<BookDto> findByPublisher(String publisher) {
        return bookRepository.findByPublisher(publisher).stream().map(element -> mapper.map(element, BookDto.class)).collect(Collectors.toList());
    }

    public List<BookDto> findByTitle(String title){
        return bookRepository.findByTitleContainingIgnoreCase(title).stream().map(book -> mapper.map(book, BookDto.class)).toList();
    }

    @Override
    public List<BookDto> findBeforePublishYear(Integer year) {
        return bookRepository.findByPublishYearBefore(year).stream().map(book -> mapper.map(book, BookDto.class)).toList();
    }

    @Override
    public ResposeDto save(BookDto bookDto) {
        bookRepository.save(mapper.map(bookDto, Book.class));
        return ResposeDto.builder().message("Saved").build();
    }
}
