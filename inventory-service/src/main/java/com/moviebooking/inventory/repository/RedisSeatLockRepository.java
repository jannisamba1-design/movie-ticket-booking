package com.moviebooking.inventory.repository;

import com.moviebooking.inventory.repository.SeatLockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RedisSeatLockRepository implements SeatLockRepository {

    private final StringRedisTemplate redisTemplate;

    @Override
    public boolean lockSeats(UUID showId, List<String> seatIds, Duration ttl) {

        for (String seatId : seatIds) {
            String key = key(showId, seatId);

            Boolean locked = redisTemplate.opsForValue()
                    .setIfAbsent(key, "LOCKED", ttl);

            if (Boolean.FALSE.equals(locked)) {
                return false; // seat already locked
            }
        }
        return true;
    }

    @Override
    public void releaseSeats(UUID showId, List<String> seatIds) {
        seatIds.forEach(seatId ->
                redisTemplate.delete(key(showId, seatId))
        );
    }

    private String key(UUID showId, String seatId) {
        return "seat-lock:" + showId + ":" + seatId;
    }
}
