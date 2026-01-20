package com.moviebooking.inventory.service;

import com.moviebooking.inventory.dto.LockRequest;
import com.moviebooking.inventory.common.exception.SeatAlreadyLockedException;
import com.moviebooking.inventory.repository.SeatLockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final SeatLockRepository seatLockRepository;

    public void lockSeats(LockRequest request) {

        boolean success = seatLockRepository.lockSeats(
                request.getShowId(),
                request.getSeatIds(),
                Duration.ofSeconds(request.getTtlSeconds())
        );

        if (!success) {
            throw new SeatAlreadyLockedException();
        }
    }

    public void releaseSeats(LockRequest request) {
        seatLockRepository.releaseSeats(
                request.getShowId(),
                request.getSeatIds()
        );
    }
}
