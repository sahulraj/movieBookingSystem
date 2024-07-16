package com.example.movieBookingSystem.entities;

import com.example.movieBookingSystem.Enums.SeatType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SHOW_SEATS")
@Data
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Integer price;
    private Boolean isAvailable;
    private Boolean isFoodContains;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Show show;
}

