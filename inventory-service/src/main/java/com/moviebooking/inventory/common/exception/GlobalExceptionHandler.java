package com.moviebooking.inventory.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SeatAlreadyLockedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String seatAlreadyBooked() {
        return "Selected seats have already been locked.";
    }
}
