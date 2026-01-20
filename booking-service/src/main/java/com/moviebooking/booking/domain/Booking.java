package com.moviebooking.booking.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Booking {

    @Id
    private UUID id;

    private UUID showId;
    private UUID userId;
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private Instant createdAt;

    public static Booking create(UUID showId, UUID userId, BigDecimal amount) {
        Booking b = new Booking();
        b.id = UUID.randomUUID();
        b.showId = showId;
        b.userId = userId;
        b.totalAmount = amount;
        b.status = BookingStatus.PENDING;
        b.createdAt = Instant.now();
        return b;
    }

    public void confirm() {
        this.status = BookingStatus.CONFIRMED;
    }

    public void fail() {
        this.status = BookingStatus.FAILED;
    }
}
