package com.example.movieBookingSystem.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "THEATERS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String address;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TheaterSeat> theaterSeatList = new ArrayList<>();

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Show> showList = new ArrayList<>();
}

