package com.example.OzgurLib.repositories;

import com.example.OzgurLib.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.username =:username")
    User getUserByUsername(@Param("username") String username);

}
