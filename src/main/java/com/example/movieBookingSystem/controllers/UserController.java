package com.example.movieBookingSystem.controllers;

import com.example.movieBookingSystem.ResponseDtos.TicketResponseDto;
import com.example.movieBookingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping("/addNew")
//    public ResponseEntity<String> addNewUser(@RequestBody UserEntryDto userEntryDto) {
//        try {
//            String result = userService.addUser(userEntryDto);
//            return new ResponseEntity<>(result, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

    @GetMapping("/allTickets")
    public ResponseEntity<List<TicketResponseDto>> allTickets() {
        try {
            List<TicketResponseDto> result = userService.allTickets();
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
