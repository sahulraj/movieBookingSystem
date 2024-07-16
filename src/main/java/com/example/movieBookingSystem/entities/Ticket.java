package com.example.movieBookingSystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@Table(name = "TICKETS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private Integer totalTicketsPrice;
    private String bookedSeats;

    @CreationTimestamp
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Show show;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private User user;

}
