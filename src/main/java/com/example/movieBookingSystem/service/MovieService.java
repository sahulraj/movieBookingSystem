package com.example.movieBookingSystem.service;

import com.example.movieBookingSystem.RequestDtos.MovieEntryDto;

public interface MovieService {
    public String addMovie(MovieEntryDto movieEntryDto);
    public Long totalCollection(Integer movieId);

}
