package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.repository.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/books/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Bookcontroller
{
    @Autowired
    Bookrepository bookrepos;

    // /books/books
    @GetMapping("/books")
    public List<Book> listAllBooks()
    {
        return bookrepos.findAll();
    }

    @GetMapping("/id/{bookid}")
    public List<Book> getStudentByStudentId(@PathVariable long bookid)
    {
        return bookrepos.findById(bookid).stream().collect(Collectors.toList());
    }

    @GetMapping("/name/{author}")
    public List<Book> getStudentByStudentName(@PathVariable String author)
    {
        return bookrepos.findBookByAuthors(author);
    }
}