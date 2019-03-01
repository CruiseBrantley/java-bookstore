package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.model.Authors;
import com.lambdaschool.bookstore.repository.Authorrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/authors/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Authorcontroller
{
    @Autowired
    Authorrepository authorrepos;

    @GetMapping(value = "/authors")
    public List<Authors> listAllauthors()
    {
        return authorrepos.findAll();
    }

    @GetMapping(value = "/id/{authorid}")
    public List<Authors> getauthorByauthorId(@PathVariable long authorid)
    {
        return authorrepos.findById(authorid).stream().collect(Collectors.toList());
    }

    @GetMapping(value = "/name/{authorname}")
    public List<Authors> getauthorByauthorName(@PathVariable String authorname)
    {
        return authorrepos.findauthorByauthornameEquals(authorname);
    }
}
