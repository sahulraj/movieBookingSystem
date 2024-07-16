package com.example.movieBookingSystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SHOWS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    private Time time;

    private Date date;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Movie movie;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Theater theater;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<ShowSeat> showSeatList = new ArrayList<>();

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Ticket> ticketList = new ArrayList<>();
}

