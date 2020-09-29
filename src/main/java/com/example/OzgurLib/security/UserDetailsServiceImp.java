package com.example.OzgurLib.security;

import com.example.OzgurLib.entities.User;
import com.example.OzgurLib.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    UserRepo userRepo;



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepo.getUserByUsername(s);


        if(user == null)
            throw new UsernameNotFoundException("Cloud not found user");


        return new MyUserDetails(user);
    }
}
