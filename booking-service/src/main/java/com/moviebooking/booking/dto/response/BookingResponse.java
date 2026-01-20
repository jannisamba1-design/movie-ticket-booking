package com.moviebooking.booking.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class BookingResponse {

    private UUID bookingId;
    private String status;
    private BigDecimal totalAmount;
}
