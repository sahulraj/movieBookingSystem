package com.example.movieBookingSystem.controllers;

import com.example.movieBookingSystem.RequestDtos.TicketEntryDto;
import com.example.movieBookingSystem.ResponseDtos.TicketResponseDto;
import com.example.movieBookingSystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/bookTicket")
    public ResponseEntity<TicketResponseDto> ticketBooking(@RequestBody TicketEntryDto ticketEntryDto) {
//        try {
//            TicketResponseDto result = ticketService.ticketBooking(ticketEntryDto);
//            return new ResponseEntity<>(result, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
        TicketResponseDto result = ticketService.ticketBooking(ticketEntryDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}

