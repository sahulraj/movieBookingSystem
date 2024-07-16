package com.example.movieBookingSystem.Exception;

public class UserDoesNotExists extends RuntimeException{
    public UserDoesNotExists() {
        super("User does not exists");
    }
}