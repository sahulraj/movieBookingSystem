package com.example.movieBookingSystem.service;

import com.example.movieBookingSystem.RequestDtos.UserEntryDto;
import com.example.movieBookingSystem.ResponseDtos.TicketResponseDto;
import com.example.movieBookingSystem.entities.User;
import com.example.movieBookingSystem.entities.UserModel;

import java.util.List;

public interface UserService {
    public String addUser(UserEntryDto userEntryDto);
    public User createUser(UserModel userModel);
    public User getLoggedInUser();
    public List<TicketResponseDto> allTickets();

}
