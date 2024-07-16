package com.vasquez.services;

import java.util.List;

import com.vasquez.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vasquez.models.Author;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void save(Author authors) {
        authorRepository.save(authors);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public List<Author> findAliveAuthorsInYear(int year) {
        return authorRepository.findAliveAuthorsInYear(year);
    };
}
