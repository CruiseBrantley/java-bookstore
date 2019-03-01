package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.model.Section;
import com.lambdaschool.bookstore.repository.Sectionrepository;
import com.lambdaschool.bookstore.repository.Authorrepository;
import com.lambdaschool.bookstore.repository.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

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

    @PutMapping("/course/{sectionid}")
    public Section changeSectionById(@RequestBody Section newcourse, @PathVariable long sectionid) throws URISyntaxException
    {
        Optional<Section> updateSection = sectionrepos.findById(sectionid);
        if (updateSection.isPresent())
        {
            if (newcourse.getAuthors() == null)
            {
                newcourse.setAuthors(updateSection.get().getAuthors());
            }

            if (newcourse.getsectionname() == null)
            {
                newcourse.setsectionname(updateSection.get().getsectionname());
            }
            newcourse.setsectionid(sectionid);
            sectionrepos.save(newcourse);

            return newcourse;
        } else
        {
            return null;
        }
    }
    @DeleteMapping("/sections/{sectionid}")
    public String deleteSectionById(@PathVariable long sectionid)
    {
        var foundSection = sectionrepos.findById(sectionid);
        if (foundSection.isPresent())
        {
//            sectionrepos.deleteSectionFromBooksections(sectionid);
            sectionrepos.deleteById(sectionid);

            return "{" + "\"sectionid\":" + foundSection.get().getsectionid() +
                    ",\"sectionname\":" + "\"" + foundSection.get().getsectionname() + "\"" +
                    ",\"Authorid\":" + foundSection.get().getAuthors().getAuthorid() + "}";
        } else
        {
            return null;
        }
    }
}
