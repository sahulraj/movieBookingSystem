package com.example.movieBookingSystem.RequestDtos;

import com.example.movieBookingSystem.Enums.Gender;
import lombok.Data;

@Data
public class UserEntryDto {

    private String name;
    private Integer age;
    private String address;
    private String mobileNo;
    private String emailId;
    private Gender gender;
}