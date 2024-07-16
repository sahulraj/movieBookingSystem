package com.example.movieBookingSystem.controllers;

import com.example.movieBookingSystem.entities.AuthModel;
import com.example.movieBookingSystem.entities.User;
import com.example.movieBookingSystem.entities.UserModel;
import com.example.movieBookingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserModel userModel)
    {
        User user = userService.createUser(userModel);
        System.out.println("register");
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
//        @PostMapping("/register")
//    public String fun()
//    {
//        return "its working";
//    }
    @PostMapping("/login")
    public ResponseEntity<HttpStatus>login(@RequestBody AuthModel authModel)
    {
        Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authModel.getUsername(), authModel.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
