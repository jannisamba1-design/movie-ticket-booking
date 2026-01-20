package com.moviebooking.booking.service;

import com.moviebooking.booking.client.InventoryClient;
import com.moviebooking.booking.common.exception.DuplicateRequestException;
import com.moviebooking.booking.domain.Booking;
import com.moviebooking.booking.domain.IdempotencyKey;
import com.moviebooking.booking.dto.request.BookingRequest;
import com.moviebooking.booking.dto.response.BookingResponse;
import com.moviebooking.booking.kafka.BookingEventPublisher;
import com.moviebooking.booking.mapper.BookingMapper;
import com.moviebooking.booking.pricing.BookingContext;
import com.moviebooking.booking.repository.BookingRepository;
import com.moviebooking.booking.repository.IdempotencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final IdempotencyRepository idempotencyRepository;
    private final InventoryClient inventoryClient;
    private final PricingService pricingService;
    private final BookingEventPublisher bookingEventPublisher;

    @Transactional
    public BookingResponse createBooking(
            String idemKey, BookingRequest req, UUID userId) {

        // Idempotency check
        idempotencyRepository.findById(idemKey)
                .ifPresent(k -> {
                    throw new DuplicateRequestException("Duplicate request");
                });

        // Lock seats
//        inventoryClient.lockSeats(req.getShowId(), req.getSeatIds());

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        CompletableFuture<Void> inventoryFuture =
                CompletableFuture.runAsync(
                        () -> inventoryClient.lockSeats(
                                req.getShowId(), req.getSeatIds()
                        ),
                        executor
                );

        CompletableFuture<BigDecimal> pricingFuture =
                CompletableFuture.supplyAsync(
                        () -> pricingService.calculate(
                                new BookingContext(req.getSeatIds().size())
                        ),
                        executor
                );

        CompletableFuture.allOf(
                inventoryFuture, pricingFuture
        ).join();

        BigDecimal amount = pricingFuture.join();

        try {
            Booking booking =
                    Booking.create(req.getShowId(), userId, amount);

            booking.confirm();
            bookingRepository.save(booking);

            idempotencyRepository.save(
                     IdempotencyKey.create(idemKey, booking.getId())
            );

            //Publish booking created event
            bookingEventPublisher.publishBookingCreated(
                    booking, req.getSeatIds()
            );
            return BookingMapper.toResponse(booking);

        } catch (Exception ex) {
            inventoryClient.releaseSeats(
                    req.getShowId(), req.getSeatIds());
            throw ex;
        }
    }
}
