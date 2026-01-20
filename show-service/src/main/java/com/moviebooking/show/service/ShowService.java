package com.moviebooking.show.service;

import com.moviebooking.show.domain.Show;
import com.moviebooking.show.dto.ShowResponse;
import com.moviebooking.show.mapper.ShowMapper;
import com.moviebooking.show.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;

    public ShowResponse getShows(UUID movieId, String city, LocalDate date) {

        List<Show> shows =
                showRepository.findShows(movieId, city, date);
        log.info("Shows found: {}", shows.size());
        log.info("Shows data: {}", shows);
        return ShowMapper.toResponse(movieId, city, date, shows);
    }
}
