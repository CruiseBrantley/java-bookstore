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
    private long Authorid;

    @Column(name = "authorname")
    private String authorname;

    @OneToMany(mappedBy = "author")
    @JsonIgnoreProperties("authors")
    private Set<Section> sections = new HashSet<>();

    public Authors()
    {
    }

    public long getAuthorid()
    {
        return Authorid;
    }

    public void setAuthorid(long Authorid)
    {
        this.Authorid = Authorid;
    }

    public String getauthorname()
    {
        return authorname;
    }

    public void setauthorname(String authorname)
    {
        this.authorname = authorname;
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
