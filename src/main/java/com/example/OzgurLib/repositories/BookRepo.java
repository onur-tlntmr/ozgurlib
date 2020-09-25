package com.example.OzgurLib.repositories;

import com.example.OzgurLib.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepo extends JpaRepository<Book,Long> {
}
