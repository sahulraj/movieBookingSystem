package com.example.movieBookingSystem.service;

import com.example.movieBookingSystem.RequestDtos.TicketEntryDto;
import com.example.movieBookingSystem.ResponseDtos.TicketResponseDto;
import com.example.movieBookingSystem.entities.ShowSeat;

import java.util.List;

public interface TicketService {
    public TicketResponseDto ticketBooking(TicketEntryDto ticketEntryDto);
    public Boolean isSeatAvailable(List<ShowSeat> showSeatList, List<String> requestSeats);
    Integer getPriceAndAssignSeats(List<ShowSeat> showSeatList, List<String> requestSeats);
    String listToString(List<String> requestSeats);


}
