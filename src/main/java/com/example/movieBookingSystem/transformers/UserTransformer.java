package com.example.movieBookingSystem.transformers;

import com.example.movieBookingSystem.RequestDtos.UserEntryDto;
import com.example.movieBookingSystem.ResponseDtos.ReturnUserDto;
import com.example.movieBookingSystem.entities.User;

public class UserTransformer {

    public static User userDtoToUser(UserEntryDto userEntryDto) {
        User user = User.builder()
                .name(userEntryDto.getName())
                .age(userEntryDto.getAge())
                .address(userEntryDto.getAddress())
                .gender(userEntryDto.getGender())
                .mobileNumber(userEntryDto.getMobileNo())
                .email(userEntryDto.getEmailId())
                .build();

        return user;
    }

    public static ReturnUserDto userToUserDto(User user) {
        ReturnUserDto userDto = ReturnUserDto.builder()
                .name(user.getName())
                .age(user.getAge())
                .address(user.getAddress())
                .gender(user.getGender())
                .build();

        return userDto;
    }
}

