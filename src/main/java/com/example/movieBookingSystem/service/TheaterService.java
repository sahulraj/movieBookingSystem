package com.example.movieBookingSystem.service;

import com.example.movieBookingSystem.RequestDtos.TheaterEntryDto;
import com.example.movieBookingSystem.RequestDtos.TheaterSeatEntryDto;

public interface TheaterService {
    public String addTheater(TheaterEntryDto theaterEntryDto);
    public String addTheaterSeat(TheaterSeatEntryDto entryDto);

}
