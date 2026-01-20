package com.moviebooking.booking.pricing;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookingContext {

    private final int seatCount;

    // Optional extensions (future-ready)
    // private final LocalTime showTime;
    // private final String city;
    // private final UUID theatreId;
}
