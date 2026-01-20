package com.moviebooking.booking.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"showId", "seatId"}
        )
)
public class BookedSeat {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID bookingId;
    private UUID showId;
    private UUID seatId;
}
