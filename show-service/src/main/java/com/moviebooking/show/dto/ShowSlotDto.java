package com.moviebooking.show.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;
import java.util.UUID;

@Getter
@Builder
public class ShowSlotDto {

    private UUID showId;
    private LocalTime showTime;
    private int availableSeats;
}
