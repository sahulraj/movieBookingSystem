package com.example.movieBookingSystem.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private String name;
    private String email;
    private String password;
    private List<String>roles;
    private String mobileNumber;


}

