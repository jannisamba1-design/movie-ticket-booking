package com.moviebooking.booking.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LockRequest {

    @NotNull(message = "showId is required")
    private UUID showId;

    @NotEmpty(message = "seatIds cannot be empty")
    @Size(max = 10, message = "Maximum 10 seats can be locked at once")
    private List<
                @Pattern(
                        regexp = "^[A-Z][0-9]{1,2}$",
                        message = "Invalid seat format"
                )
                        String
                > seatIds;

    @Min(value = 60, message = "TTL must be at least 60 seconds")
    @Max(value = 600, message = "TTL cannot exceed 10 minutes")
    private int ttlSeconds;
}
