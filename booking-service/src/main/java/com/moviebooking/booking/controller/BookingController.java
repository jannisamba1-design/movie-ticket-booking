package com.moviebooking.booking.controller;

import com.moviebooking.booking.dto.request.BookingRequest;
import com.moviebooking.booking.dto.response.BookingResponse;
import com.moviebooking.booking.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public BookingResponse book(
            @RequestHeader("Idempotency-Key") String key,
            @RequestBody @Valid BookingRequest req,
            @RequestHeader("X-User-Id") UUID userId) {

        return bookingService.createBooking(
                key, req, userId);
    }
}
