package com.vasquez.models;

import java.util.List;
import java.util.stream.Collectors;

import com.vasquez.DTO.AuthorDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    public Book(String title, List<AuthorDTO> authorDTOs, List<String> languages, Double downloadTotal) {
        this.title = title;
        this.authors = authorDTOs.stream()
                .map(authorDTO -> new Author(authorDTO.name(), authorDTO.birthYear(), authorDTO.deathYear()))
                .collect(Collectors.toList());
        this.languages = languages;
        this.downloadTotal = downloadTotal;
    }

    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "book_author", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
            @JoinColumn(name = "author_id") })
    private List<Author> authors;

    private List<String> languages;

    private Double downloadTotal;

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", languages=" + languages + ", downloadTotal=" + downloadTotal
                + "]";
    }

}
