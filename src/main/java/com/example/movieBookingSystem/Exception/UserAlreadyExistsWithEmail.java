package com.example.movieBookingSystem.Exception;

public class UserAlreadyExistsWithEmail extends RuntimeException {
    public UserAlreadyExistsWithEmail() {
        super("User Already Exists with this EmailId");
    }
}

