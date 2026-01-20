package com.moviebooking.booking.repository;

import com.moviebooking.booking.domain.BookedSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SeatRepository extends JpaRepository<BookedSeat, UUID> {

    List<BookedSeat> findByIdIn(List<UUID> ids);
}
