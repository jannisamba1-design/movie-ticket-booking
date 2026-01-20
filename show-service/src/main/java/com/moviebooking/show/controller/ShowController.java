package com.moviebooking.show.controller;

import com.moviebooking.show.dto.ShowResponse;
import com.moviebooking.show.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @GetMapping("/{movieId}/shows")
    public ShowResponse getShows(
            @PathVariable UUID movieId,
            @RequestParam String city,
            @RequestParam LocalDate date) {

        return showService.getShows(movieId, city, date);
    }
}
