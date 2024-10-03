package com.bookservice.service;


import com.bookservice.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    String addBook(Book book);
    void deleteBook(Long id);
    Book findBookById(Long id);
}
