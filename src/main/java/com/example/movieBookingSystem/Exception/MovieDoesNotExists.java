package com.example.movieBookingSystem.Exception;

public class MovieDoesNotExists extends RuntimeException{
    public MovieDoesNotExists() {
        super("Movie dose not Exists");
    }
}
