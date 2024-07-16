package com.example.movieBookingSystem.Exception;

public class ShowDoesNotExists extends RuntimeException{

    public ShowDoesNotExists() {
        super("Show does not exists");
    }
}