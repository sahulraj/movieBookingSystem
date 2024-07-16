package com.example.movieBookingSystem.RequestDtos;

import lombok.Data;

import java.sql.Date;

@Data
public class ShowTimingsDto {
    private Date date;
    private Integer theaterId;
    private Integer movieId;
}