package com.wecp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wecp.entities.User;
import com.wecp.exception.UserNameNotFoundException;
import com.wecp.jwt.JwtUtil;
import com.wecp.model.LoginRequest;
import com.wecp.model.LoginResponse;
import com.wecp.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @PostMapping("/sign-up")
    public ResponseEntity addNewUser(@RequestBody User user) {
        userService.addUser(user);
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        //TODO: process POST request
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            User user = userService.getUserByUserEmail(loginRequest.getUsername());
            String role = user.getRole();
            LoginResponse loginResponse = new LoginResponse(jwtUtil.generateToken(loginRequest.getUsername()), user.getRole());
            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        } else {
            throw new UserNameNotFoundException("invalid user request !");
        }
    }
    
    
}
