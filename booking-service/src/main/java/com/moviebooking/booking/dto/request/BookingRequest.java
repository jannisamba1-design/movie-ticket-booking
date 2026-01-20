package com.moviebooking.booking.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {

    @NotNull(message = "showId is required")
    private UUID showId;

    @NotEmpty(message = "At least one seat must be selected")
    private List<
                @Pattern(
                        regexp = "^[A-Z][0-9]{1,2}$",
                        message = "Invalid seat format"
                )
                        String
                > seatIds;
}
