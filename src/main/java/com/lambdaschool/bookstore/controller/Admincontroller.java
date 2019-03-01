package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.repository.Sectionrepository;
import com.lambdaschool.bookstore.repository.Authorrepository;
import com.lambdaschool.bookstore.repository.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/admin/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Admincontroller
{
    @Autowired
    Sectionrepository sectionrepos;

    @Autowired
    Authorrepository authorrepos;

    @Autowired
    Bookrepository bookrepos;

}
