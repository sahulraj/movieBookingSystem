package com.example.movieBookingSystem.service;

import com.example.movieBookingSystem.Exception.MovieAlreadyPresentWithSameNameAndLanguage;
import com.example.movieBookingSystem.Exception.MovieDoesNotExists;
import com.example.movieBookingSystem.RequestDtos.MovieEntryDto;
import com.example.movieBookingSystem.entities.Movie;
import com.example.movieBookingSystem.entities.Show;
import com.example.movieBookingSystem.entities.Ticket;
import com.example.movieBookingSystem.repositories.MovieRepository;
import com.example.movieBookingSystem.repositories.ShowRepository;
import com.example.movieBookingSystem.transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowRepository showRepository;

    public String addMovie(MovieEntryDto movieEntryDto) throws MovieAlreadyPresentWithSameNameAndLanguage {
        if(movieRepository.findByMovieName(movieEntryDto.getMovieName()) != null) {
            if(movieRepository.findByMovieName(movieEntryDto.getMovieName()).getLanguage().equals(movieEntryDto.getLanguage())){
                throw new MovieAlreadyPresentWithSameNameAndLanguage();
            }
        }
        Movie movie = MovieTransformer.movieDtoToMovie(movieEntryDto);
        movieRepository.save(movie);
        return "The movie has been added successfully";
    }

    public Long totalCollection(Integer movieId) throws MovieDoesNotExists {
        Optional<Movie> movieOpt = movieRepository.findById(movieId);
        if(movieOpt.isEmpty()) {
            throw new MovieDoesNotExists();
        }
        List<Show> showListOfMovie = showRepository.getAllShowsOfMovie(movieId);
        long ammount = 0;
        for(Show show : showListOfMovie) {
            for(Ticket ticket : show.getTicketList()) {
                ammount += (long)ticket.getTotalTicketsPrice();
            }
        }
        return ammount;
    }
}
