package com.moviebooking.show.mapper;

import com.moviebooking.show.domain.Show;
import com.moviebooking.show.domain.Theatre;
import com.moviebooking.show.dto.ShowResponse;
import com.moviebooking.show.dto.ShowSlotDto;
import com.moviebooking.show.dto.TheatreShowsDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public final class ShowMapper {

    private ShowMapper() {
        // utility class
    }

    // ✅ SIMPLE VERSION (used now)
    public static ShowResponse toResponse(
            UUID movieId,
            String city,
            LocalDate date,
            List<Show> shows
    ) {
        return toResponse(movieId, city, date, shows, Map.of());
    }

    // ✅ EXTENDED VERSION (future / inventory integration)
    public static ShowResponse toResponse(
            UUID movieId,
            String city,
            LocalDate date,
            List<Show> shows,
            Map<UUID, Integer> availableSeatMap
    ) {

        Map<Theatre, List<Show>> grouped =
                shows.stream()
                        .collect(Collectors.groupingBy(
                                show -> show.getScreen().getTheatre()
                        ));

        List<TheatreShowsDto> theatreDtos =
                grouped.entrySet()
                        .stream()
                        .map(entry ->
                                toTheatreDto(
                                        entry.getKey(),
                                        entry.getValue(),
                                        availableSeatMap
                                )
                        )
                        .toList();

        return ShowResponse.builder()
                .movieId(movieId)
                .city(city)
                .date(date)
                .theatres(theatreDtos)
                .build();
    }

    private static TheatreShowsDto toTheatreDto(
            Theatre theatre,
            List<Show> shows,
            Map<UUID, Integer> availableSeatMap
    ) {

        List<ShowSlotDto> slots =
                shows.stream()
                        .map(show -> ShowSlotDto.builder()
                                .showId(show.getId())
                                .showTime(show.getShowTime())
                                .availableSeats(
                                        availableSeatMap.getOrDefault(
                                                show.getId(),
                                                show.getScreen().getSeatCount()
                                        )
                                )
                                .build())
                        .toList();

        return TheatreShowsDto.builder()
                .theatreId(theatre.getId())
                .theatreName(theatre.getName())
                .shows(slots)
                .build();
    }
}
