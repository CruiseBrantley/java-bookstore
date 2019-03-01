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
    private long section;

    private String name;


    public Section(){}

    public long getsection()
    {
        return section;
    }

    public void setsection(long section)
    {
        this.section = section;
    }

    public String getname()
    {
        return name;
    }

    public void setname(String name)
    {
        this.name = name;
    }
}
