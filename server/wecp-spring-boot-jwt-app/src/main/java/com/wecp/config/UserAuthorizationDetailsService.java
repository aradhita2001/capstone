package com.wecp.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.wecp.entities.User;
import com.wecp.exception.UserNameNotFoundException;
import com.wecp.repos.UserRepository;

@Component
public class UserAuthorizationDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email)  {
        // TODO Auto-generated method stub
        Optional<User> user = userRepository.findByEmail(email);

        // TODO
        return user.map(UserAuthorizationDetails::new).orElseThrow(()-> new UserNameNotFoundException()); 

    }
    
}