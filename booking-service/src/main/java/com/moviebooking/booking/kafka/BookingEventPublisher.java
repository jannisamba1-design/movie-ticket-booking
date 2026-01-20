package com.moviebooking.booking.kafka;

import com.moviebooking.booking.domain.Booking;
import com.moviebooking.booking.domain.BookingCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookingEventPublisher {

    private final KafkaTemplate<String, BookingCreatedEvent> kafkaTemplate;

    public void publishBookingCreated(Booking booking, List<String> seatIds) {

        BookingCreatedEvent event =
                new BookingCreatedEvent(
                        booking.getId(),
                        booking.getShowId(),
                        seatIds,
                        booking.getTotalAmount(),
                        booking.getCreatedAt()
                );

        kafkaTemplate.send(
                "booking.created",
                booking.getId().toString(),
                event
        );
    }
}
