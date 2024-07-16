package com.example.movieBookingSystem.Exception;

public class TheaterIsPresentOnThatAddress extends RuntimeException{
    public TheaterIsPresentOnThatAddress() {
        super("Theater is already Present on this Address");
    }
}
