package com.example.movieBookingSystem.Exception;

public class TheaterDoesNotExists extends RuntimeException{
    public TheaterDoesNotExists() {
        super("Theater does not Exists");
    }
}
