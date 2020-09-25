package com.example.OzgurLib.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 11,updatable = false)
    private Long id;


    @Column( length = 60,nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Lob
    private String photo;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinTable(
            name = "authors_books",
            joinColumns = @JoinColumn(name="author_id"),
            inverseJoinColumns = @JoinColumn(name="book_id")
    )
    private Set<Book> books = new HashSet<>();


    public Author() {
    }

    public Author(Long id, String name, String description, String photo, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> bookSet) {
        this.books = bookSet;
    }
}
