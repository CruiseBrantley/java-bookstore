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
@RequestMapping(value = "/students/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Bookcontroller
{
    @Autowired
    Bookrepository bookrepos;

    // /students/students
    @GetMapping("/students")
    public List<Book> listAllStudents()
    {
        return bookrepos.findAll();
    }

    @GetMapping("/id/{studentid}")
    public List<Book> getStudentByStudentId(@PathVariable long studentid)
    {
        return bookrepos.findById(studentid).stream().collect(Collectors.toList());
    }

    @GetMapping("/name/{studname}")
    public List<Book> getStudentByStudentName(@PathVariable String studname)
    {
        return bookrepos.findStudentByStudnameEquals(studname);
    }
}