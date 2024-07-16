package com.example.movieBookingSystem.repositories;

import com.example.movieBookingSystem.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findByMovieName(String name);
}
