package com.moviebooking.booking.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class BookingCreatedEvent {

    private UUID bookingId;
    private UUID showId;
    private List<String> seatIds;
    private BigDecimal amount;
    private Instant createdAt;
}
