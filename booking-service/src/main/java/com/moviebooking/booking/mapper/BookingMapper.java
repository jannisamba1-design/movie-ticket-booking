package com.moviebooking.booking.mapper;

import com.moviebooking.booking.domain.Booking;
import com.moviebooking.booking.dto.response.BookingResponse;

public final class BookingMapper {

    private BookingMapper() {
        // utility class
    }

    public static BookingResponse toResponse(Booking booking) {

        return BookingResponse.builder()
                .bookingId(booking.getId())
                .status(booking.getStatus().name())
                .totalAmount(booking.getTotalAmount())
                .build();
    }
}
