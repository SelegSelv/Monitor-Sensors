package com.monitorsensors.service;

import com.monitorsensors.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UsersService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username)  {
        return usersRepository.findByUsername(username).map(users -> new User(users.getUsername()
                        ,users.getPassword()
                        , Collections.singleton(users.getRole())))
                .orElseThrow(()->new UsernameNotFoundException("Failed to retrieve user: "+username));

    }
}
