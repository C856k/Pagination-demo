package com.example.paginationdemo.repository;

import com.example.paginationdemo.entity.Book;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository  extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b WHERE " +
            "(LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%')) OR :title IS NULL) AND " +
            "(LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%')) OR :author IS NULL)")

    Page<Book> findByAuthorContainingIgnoreCase(String title, Pageable pageable);
    Page<Book> findByAuthorLikeIgnoreCase(String title,Pageable pageable);

}
