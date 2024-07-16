package com.example.movieBookingSystem.RequestDtos;

import lombok.Data;

@Data
public class TheaterSeatEntryDto {
    private String address;
    private Integer noOfSeatInRow;
    private Integer noOfPremiumSeat;
    private Integer noOfClassicSeat;
}

