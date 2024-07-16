package com.example.movieBookingSystem.service;

import com.example.movieBookingSystem.RequestDtos.ShowEntryDto;
import com.example.movieBookingSystem.RequestDtos.ShowSeatEntryDto;
import com.example.movieBookingSystem.RequestDtos.ShowTimingsDto;
import com.example.movieBookingSystem.entities.Show;

import java.util.List;

public interface ShowService {
    public String addShow(ShowEntryDto showEntryDto);
    public String associateShowSeats(ShowSeatEntryDto showSeatEntryDto);
    public List<Show> showTimingsOnDate(ShowTimingsDto showTimingsDto);
    public String movieHavingMostShows();


}
