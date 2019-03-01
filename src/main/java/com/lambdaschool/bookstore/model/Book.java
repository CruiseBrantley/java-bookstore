package com.lambdaschool.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookid;

    private String bookname;

    @ManyToMany
    @JoinTable(name = "booksections",
            joinColumns = {@JoinColumn(name = "bookid")},
            inverseJoinColumns = {@JoinColumn(name = "sectionid")})
    @JsonIgnoreProperties("book")
    private Set<Section> sections = new HashSet<>();

    public Book()
    {
    }

    public long getBookid()
    {
        return bookid;
    }

    public void setBookid(long bookid)
    {
        this.bookid = bookid;
    }

    public String getBookname()
    {
        return bookname;
    }

    public void setBookname(String bookname)
    {
        this.bookname = bookname;
    }

    public Set<Section> getsections()
    {
        return sections;
    }

    public void setsections(Set<Section> sections)
    {
        this.sections = sections;
    }
}
