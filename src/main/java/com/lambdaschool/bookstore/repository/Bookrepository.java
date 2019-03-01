package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Bookrepository extends JpaRepository<Book, Long>
{
    List<Book> findBookByAuthors(String name);
}
