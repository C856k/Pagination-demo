package com.example.paginationdemo.controller;

import com.example.paginationdemo.entity.Book;
import com.example.paginationdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public Page<Book> getAllBooks(Pageable pageable, @RequestParam(name = "author",required = false) String author ) {
        System.out.println("pageable = " + pageable);
        return bookService.getAllBooks(pageable, author);
    }
}
