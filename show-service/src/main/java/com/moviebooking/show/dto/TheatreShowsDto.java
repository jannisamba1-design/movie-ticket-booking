package com.moviebooking.show.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class TheatreShowsDto {

    private UUID theatreId;
    private String theatreName;
    private List<ShowSlotDto> shows;
}
