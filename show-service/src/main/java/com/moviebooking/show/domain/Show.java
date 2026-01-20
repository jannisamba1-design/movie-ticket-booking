package com.moviebooking.show.domain;

import com.moviebooking.show.domain.Screen;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(
        name = "\"show\"",
        indexes = {
                @Index(name = "idx_show_movie_date", columnList = "movie_id, show_date"),
                @Index(name = "idx_show_screen", columnList = "screen_id")
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Show {

    @Id
    private UUID id;

    @Column(name = "movie_id", nullable = false)
    private UUID movieId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

    @Column(name = "show_date", nullable = false)
    private LocalDate showDate;

    @Column(name = "show_time", nullable = false)
    private LocalTime showTime;
}
