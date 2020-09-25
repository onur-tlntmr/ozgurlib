package com.example.OzgurLib.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @Column(length = 11,updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(length = 75,nullable = false)
    String name;

    @Column(columnDefinition = "TEXT")
    String description;

    @OneToMany(mappedBy = "publisher",cascade = CascadeType.ALL)
    private List<Book> books;


    public Publisher() {
    }


    public Publisher(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
