package com.example.OzgurLib.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 13,updatable = false)
    private Long id;

    @Column(length = 90,nullable = false)
    private String name;



    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

    @Lob
    private String picture;

    @Column(length = 13,nullable = false)
    private String isbnNumber;

    @Column(length = 50, nullable = false)
    private String serialNumber;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    Publisher publisher;


    public Book() {
    }

    public Book(String name, Author author, String picture, String isbnNumber, String serialNumber,String description,Publisher publisher) {
        this.name = name;
        this.author = author;
        this.picture = picture;
        this.isbnNumber = isbnNumber;
        this.serialNumber = serialNumber;
        this.description = description;
        this.publisher = publisher;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
