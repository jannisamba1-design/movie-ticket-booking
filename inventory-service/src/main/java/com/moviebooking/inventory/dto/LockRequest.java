package com.moviebooking.inventory.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class LockRequest {

    @NotNull
    private UUID showId;

    @NotEmpty
    private List<String> seatIds;

    @Min(60)
    private int ttlSeconds = 300;
}
