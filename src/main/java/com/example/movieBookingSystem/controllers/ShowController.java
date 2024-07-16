package com.example.movieBookingSystem.controllers;

import com.example.movieBookingSystem.RequestDtos.ShowEntryDto;
import com.example.movieBookingSystem.RequestDtos.ShowSeatEntryDto;
import com.example.movieBookingSystem.entities.Show;
import com.example.movieBookingSystem.repositories.ShowRepository;
import com.example.movieBookingSystem.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/show")
public class ShowController {

    @Autowired
    private ShowService showService;
    @Autowired
    private ShowRepository showRepository;

    @PostMapping("/addNew")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto) {
        try {
            String result = showService.addShow(showEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/associateSeats")
    public ResponseEntity<String> associateShowSeats(@RequestBody ShowSeatEntryDto showSeatEntryDto) {
        try {
            String result = showService.associateShowSeats(showSeatEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/showTimeByMovieAndTheaterAndDate")
    public ResponseEntity<List<Time>>showBymovieAndTheater(@RequestParam("movie")Integer id, @RequestParam("theater")Integer theaterId, @RequestParam("date") Date date)
    {
        List<Show>shows = showRepository.findShowByMovieIdAndTheaterIdAndDate(id, theaterId, date);
        List<Time>times = new ArrayList<>();
        for(Show show : shows)
        {
            times.add(show.getTime());
        }
        System.out.println(times);
        return new ResponseEntity<>(times, HttpStatus.OK);
    }

    @GetMapping("/movieHavingMostShows")
    public ResponseEntity<String> movieHavingMostShows() {
        try {
            String movie = showService.movieHavingMostShows();
            return new ResponseEntity<>(movie, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/allShows")
    public List<Show>allshows()
    {
        return showRepository.findAll();
    }

}
