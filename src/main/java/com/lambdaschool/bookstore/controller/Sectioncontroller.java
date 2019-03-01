package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.repository.Sectionrepository;
import com.lambdaschool.bookstore.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/sections/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Sectioncontroller
{
    @Autowired
    Sectionrepository sectionrepos;

    @GetMapping("/sections")
    public List<Section> listAllsections()
    {
        return sectionrepos.findAll();
    }

    @GetMapping(value = "/id/{sectionid}")
    public List<Section> getSectionBysectionid(@PathVariable long sectionid)
    {
        return sectionrepos.findById(sectionid).stream().collect(Collectors.toList());
    }

    @GetMapping(value = "/name/{sectionname}")
    public List<Section> getSectionBysectionname(@PathVariable String sectionname)
    {
        return sectionrepos.findSectionByNameEquals(sectionname);
    }
}
