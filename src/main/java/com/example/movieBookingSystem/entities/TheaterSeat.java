package com.example.movieBookingSystem.entities;

import com.example.movieBookingSystem.Enums.SeatType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "THEATER_SEATS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TheaterSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Theater theater;
}
