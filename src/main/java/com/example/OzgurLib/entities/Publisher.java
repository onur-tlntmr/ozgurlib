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

    @Column(length = 200)
    String webSite;


    @OneToMany(mappedBy = "publisher",cascade = CascadeType.ALL)
    private List<Book> books;


    public Publisher() {
    }


    public Publisher(String name,String webSite, String description) {
        this.name = name;
        this.webSite = webSite;
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

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
