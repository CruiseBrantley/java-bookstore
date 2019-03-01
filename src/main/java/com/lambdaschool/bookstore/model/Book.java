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

    private String booktitle;

    private String ISBN;

    private int copy;

    @OneToMany
    @JoinTable(name = "sectionid",
            joinColumns = {@JoinColumn(name = "bookid")},
            inverseJoinColumns = {@JoinColumn(name = "sectionid")})
    @JsonIgnoreProperties("book")
    private Set<Section> sectionid = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "authorid",
            joinColumns = {@JoinColumn(name = "authorid")},
            inverseJoinColumns = {@JoinColumn(name = "bookid")})
    @JsonIgnoreProperties("authorid")
    private Set<Authors> authors = new HashSet<>();

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

    public String getBooktitle()
    {
        return booktitle;
    }

    public void setBooktitle(String booktitle)
    {
        this.booktitle = booktitle;
    }

    public Set<Section> getsectionid()
    {
        return sectionid;
    }

    public void setsectionid(Set<Section> sectionid)
    {
        this.sectionid = sectionid;
    }
}
