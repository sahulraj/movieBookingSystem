package com.example.movieBookingSystem.repositories;

import com.example.movieBookingSystem.entities.Theater;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    Theater findByAddress(String address);
}
