package com.example.movieBookingSystem.ResponseDtos;

import com.example.movieBookingSystem.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReturnUserDto {

    private String name;
    private Integer age;
    private Gender gender;
    private String address;
}