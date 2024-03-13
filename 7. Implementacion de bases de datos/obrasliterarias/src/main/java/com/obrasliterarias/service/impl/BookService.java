package com.obrasliterarias.service.impl;

import com.obrasliterarias.dto.BookDto;
import com.obrasliterarias.dto.BookRequestDto;
import com.obrasliterarias.dto.ResponseDto;
import com.obrasliterarias.model.Book;
import com.obrasliterarias.repository.IBookRepository;
import com.obrasliterarias.service.IBookService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    private final IBookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public ResponseDto saveBook(BookRequestDto bookRequestDto) {
        Book book = modelMapper.map(bookRequestDto, Book.class);
        this.bookRepository.save(book);
        return new ResponseDto("Book created");
    }

    @Override
    public List<BookDto> getBooksByAutor(String autor){
        List<Book> booksList = bookRepository.findBooksByAutor(autor);
        return convertListBookToListBookDto(booksList);
    }

    @Override
    public List<BookDto> getAllBooks(){
        List<Book> bookList = bookRepository.findAll();
        return convertListBookToListBookDto(bookList);
    }

    @Override
    public List<BookDto> getBooksBeforeYear(Integer year) {
        List<Book> bookList = bookRepository.findBooksByPublicationYearBefore(year);
        return convertListBookToListBookDto(bookList);
    }

    @Override
    public List<BookDto> getBooksByPublisher(String editorial) {
        List<Book> bookList = bookRepository.findBooksByEditorial(editorial);
        return convertListBookToListBookDto(bookList);
    }
    @Override
    public List<BookDto> getTop5BooksByTotalPagesOrderDesc(){
        List<Book> bookList = bookRepository.findTop5ByOrderByTotalPagesDesc();
        return convertListBookToListBookDto(bookList);
    }

    @Override
    public List<BookDto> getByName(String name){
        System.out.println(name);
        List<Book> bookList = bookRepository.findByNameContaining(name);
        return convertListBookToListBookDto(bookList);
    }

    private List<BookDto> convertListBookToListBookDto(List<Book> bookList){
        return bookList.stream().map(b -> modelMapper.map(b, BookDto.class)).toList();
    }
}
