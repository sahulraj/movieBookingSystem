package com.example.movieBookingSystem.Exception;

public class TheaterIsNotPresentOnThisAddress extends RuntimeException{
    public TheaterIsNotPresentOnThisAddress() {
        super("Theater is not present in this address");
    }
}

