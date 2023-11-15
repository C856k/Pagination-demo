package com.example.paginationdemo.service;

import com.example.paginationdemo.entity.Book;
import com.example.paginationdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Page<Book> getAllBooks(Pageable pageable, String author) {
        if (author != null){
            Page<Book> page = bookRepository.findByAuthorContainingIgnoreCase(author,pageable);
            return page;
        } else {
            Page<Book> book = bookRepository.findAll(pageable);
            return book;
        }
    }

}
