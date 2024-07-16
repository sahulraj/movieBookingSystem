package com.example.movieBookingSystem.transformers;

import com.example.movieBookingSystem.RequestDtos.ShowEntryDto;
import com.example.movieBookingSystem.entities.Show;

public class ShowTransformer {

    public static Show showDtoToShow(ShowEntryDto showEntryDto) {
        Show show = Show.builder()
                .time(showEntryDto.getShowStartTime())
                .date(showEntryDto.getShowDate())
                .build();

        return show;
    }
}