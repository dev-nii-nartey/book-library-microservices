package com.bookservice.service;


import com.bookservice.exception.BookAlreadyExistException;
import com.bookservice.model.Book;
import com.bookservice.repos.BookRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@AllArgsConstructor
@Service
public class IBookServiceImpl implements IBookService {


    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        log.info("getting all books");
        return bookRepository.findAll();
    }


    @Override
    @Transactional
    public String addBook(Book book) {
        Optional<Book> existingBook = bookRepository.findByTitleAndAuthor(book.getTitle(), book.getAuthor());
        if (existingBook.isPresent()) {
            throw new BookAlreadyExistException("A book with the title: " + book.getTitle() + " by author: " + book.getAuthor() + " already exists");
        }
        bookRepository.save(book);
        return book.getTitle() + " book is created successfully";
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).get();
    }
}


