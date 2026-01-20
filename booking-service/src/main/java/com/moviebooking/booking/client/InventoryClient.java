package com.moviebooking.booking.client;

import com.moviebooking.booking.dto.request.LockRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class InventoryClient {

    private final RestTemplate restTemplate;

    public void lockSeats(UUID showId, List<String> seats) {
        restTemplate.postForEntity(
                "http://inventory-service:9093/inventory/lock",
                new LockRequest(showId, seats, 300),
                Void.class
        );
    }

    public void releaseSeats(UUID showId, List<String> seats) {
        restTemplate.postForEntity(
                "http://inventory-service:9093/inventory/release",
                new LockRequest(showId, seats, 0),
                Void.class
        );
    }
}
