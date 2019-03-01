package com.lambdaschool.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "section")
public class Section
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sectionid;

    private String sectionname;

    @ManyToOne
    @JoinColumn(name = "authorid")
    @JsonIgnoreProperties("sections")
    private Authors authors;

    @ManyToMany(mappedBy = "sections")
    @JsonIgnoreProperties("sections")
    private Set<Book> books = new HashSet<>();

    public Section(){}

    public long getsectionid()
    {
        return sectionid;
    }

    public void setsectionid(long sectionid)
    {
        this.sectionid = sectionid;
    }

    public String getsectionname()
    {
        return sectionname;
    }

    public void setsectionname(String sectionname)
    {
        this.sectionname = sectionname;
    }

    public Authors getAuthors()
    {
        return authors;
    }

    public void setAuthors(Authors authors)
    {
        this.authors = authors;
    }

    public Set<Book> getBooks()
    {
        return books;
    }

    public void setBooks(Set<Book> books)
    {
        this.books = books;
    }
}
