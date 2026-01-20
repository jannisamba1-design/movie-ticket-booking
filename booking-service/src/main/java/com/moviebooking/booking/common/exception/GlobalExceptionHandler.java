package com.moviebooking.booking.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SeatAlreadyBookedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String seatAlreadyBooked() {
        return "One or more seats already booked";
    }

    @ExceptionHandler(DuplicateRequestException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String duplicateBookingRequest() {
        return "Duplicate booking request";
    }
}
