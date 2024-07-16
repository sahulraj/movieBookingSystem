package com.example.movieBookingSystem.transformers;


import com.example.movieBookingSystem.RequestDtos.TheaterEntryDto;
import com.example.movieBookingSystem.entities.Theater;

public class TheaterTransformer {

    public static Theater theaterDtoToTheater(TheaterEntryDto entryDto) {
        Theater theater = Theater.builder()
                .name(entryDto.getName())
                .address(entryDto.getAddress())
                .build();
        return theater;
    }
}

