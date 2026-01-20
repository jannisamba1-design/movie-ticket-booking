package com.moviebooking.show.repository;

import com.moviebooking.show.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ShowRepository extends JpaRepository<Show, UUID> {

    @Query("""
        SELECT s FROM Show s
        JOIN s.screen sc
        JOIN sc.theatre t
        WHERE s.movieId = :movieId
          AND t.city = :city
          AND s.showDate = :date
    """)
    List<Show> findShows(UUID movieId, String city, LocalDate date);
}
