package com.moviebooking.inventory.repository;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

public interface SeatLockRepository {

    boolean lockSeats(UUID showId, List<String> seatIds, Duration ttl);

    void releaseSeats(UUID showId, List<String> seatIds);
}
