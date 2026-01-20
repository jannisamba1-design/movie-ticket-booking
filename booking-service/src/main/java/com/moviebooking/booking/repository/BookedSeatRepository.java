package com.moviebooking.booking.repository;

import com.moviebooking.booking.domain.BookedSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookedSeatRepository extends JpaRepository<BookedSeat, UUID> {

    List<BookedSeat> findByShowIdAndSeatIdIn(UUID showId, List<UUID> seatIds);
}
