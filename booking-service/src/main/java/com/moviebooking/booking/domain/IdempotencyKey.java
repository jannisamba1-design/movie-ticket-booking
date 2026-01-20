package com.moviebooking.booking.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IdempotencyKey {

    @Id
    private String key;

    @Column(nullable = false)
    private UUID bookingId;

    @Column(nullable = false)
    private Instant createdAt;

    // ✅ Static factory method
    public static IdempotencyKey create(String key, UUID bookingId) {
        IdempotencyKey entity = new IdempotencyKey();
        entity.key = key;
        entity.bookingId = bookingId;
        entity.createdAt = Instant.now();
        return entity;
    }
}
