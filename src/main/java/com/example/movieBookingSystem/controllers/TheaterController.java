package com.example.movieBookingSystem.controllers;

import com.example.movieBookingSystem.RequestDtos.TheaterEntryDto;
import com.example.movieBookingSystem.RequestDtos.TheaterSeatEntryDto;
import com.example.movieBookingSystem.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/theater/addNew")
    public ResponseEntity<String> addTheater(@RequestBody TheaterEntryDto theaterEntryDto) {
        try {
            String result = theaterService.addTheater(theaterEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/theater/addTheaterSeat")
    public ResponseEntity<String> addTheaterSeat(@RequestBody TheaterSeatEntryDto entryDto) {
        try {
            String result = theaterService.addTheaterSeat(entryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

