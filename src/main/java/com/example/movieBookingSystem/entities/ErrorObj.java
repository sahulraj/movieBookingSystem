package com.example.movieBookingSystem.entities;

import lombok.Data;

import java.util.Date;
@Data
public class ErrorObj {
    private String message;
    private Integer statusCode;
    private Date timestamp;
}
