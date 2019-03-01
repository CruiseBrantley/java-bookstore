package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Authorrepository extends JpaRepository<Authors, Long>
{
    List<Authors> findAuthorsByFirstnameAndLastname(String firstname, String lastname);
}

