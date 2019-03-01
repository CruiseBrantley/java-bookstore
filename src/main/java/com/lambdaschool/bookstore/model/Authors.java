package com.lambdaschool.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Authors
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorid;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @ManyToMany
    @JoinTable(name = "bookid",
            joinColumns = {@JoinColumn(name = "bookid")},
            inverseJoinColumns = {@JoinColumn(name = "authorid")})
    @JsonIgnoreProperties("bookid")
    private Set<Book> books = new HashSet<>();

    public Authors(){}

    public long getAuthorid()
    {
        return authorid;
    }

    public void setAuthorid(long Authorid)
    {
        this.authorid = Authorid;
    }

    public String getauthorname()
    {
        return firstname + lastname;
    }

    public void setauthorname(String firstname, String lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
