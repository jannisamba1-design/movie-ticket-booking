package com.moviebooking.inventory.kafka;

import com.moviebooking.inventory.domain.BookingCreatedEvent;
import com.moviebooking.inventory.repository.SeatLockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InventoryBookingConsumer {

    private final SeatLockRepository seatLockRepository;

    @KafkaListener(
            topics = "booking.created",
            groupId = "inventory-service"
    )
    public void handleBookingCreated(BookingCreatedEvent event) {

        // 1️⃣ Remove temporary locks
        seatLockRepository.releaseSeats(
                event.getShowId(),
                event.getSeatIds()
        );

        // 2️⃣ (Future) persist booked seats
        // bookingSeatRepository.save(...)

        System.out.println(
                "Inventory updated for booking " + event.getBookingId()
        );
    }
}
