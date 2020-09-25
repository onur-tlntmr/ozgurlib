package com.example.OzgurLib.repositories;

import com.example.OzgurLib.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Long> {
}
