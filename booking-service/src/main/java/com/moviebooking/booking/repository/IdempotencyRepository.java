package com.moviebooking.booking.repository;

import com.moviebooking.booking.domain.IdempotencyKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdempotencyRepository
        extends JpaRepository<IdempotencyKey, String> {
}
