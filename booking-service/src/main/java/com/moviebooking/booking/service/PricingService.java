package com.moviebooking.booking.service;

import com.moviebooking.booking.pricing.BookingContext;
import com.moviebooking.booking.pricing.DiscountStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PricingService {

    private final List<DiscountStrategy> strategies;

    public BigDecimal calculate(BookingContext ctx) {
        BigDecimal price =
                BigDecimal.valueOf(ctx.getSeatCount() * 200);

        for (DiscountStrategy s : strategies) {
            if (s.applies(ctx)) {
                price = s.apply(price);
            }
        }
        return price;
    }
}
