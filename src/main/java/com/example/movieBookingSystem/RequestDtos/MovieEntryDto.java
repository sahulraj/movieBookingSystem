package com.example.movieBookingSystem.RequestDtos;

import com.example.movieBookingSystem.Enums.Genre;
import com.example.movieBookingSystem.Enums.Language;
import lombok.Data;

import java.sql.Date;

@Data
public class MovieEntryDto {
    private String movieName;
    private Integer duration;
    private Double rating;
    private Date releaseDate;
    private Genre genre;
    private Language language;
}
