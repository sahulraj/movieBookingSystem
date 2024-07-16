package com.example.movieBookingSystem.Exception;

public class RequestedSeatAreNotAvailable extends RuntimeException{
    public RequestedSeatAreNotAvailable() {
        super("Requested Seats Are Not Available or Occupied");
    }
}
