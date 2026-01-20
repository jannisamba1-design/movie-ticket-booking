package com.moviebooking.show.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class ShowResponse {

    private UUID movieId;
    private String city;
    private LocalDate date;
    private List<TheatreShowsDto> theatres;
}
